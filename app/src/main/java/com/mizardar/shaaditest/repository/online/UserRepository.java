package com.mizardar.shaaditest.repository.online;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.mizardar.shaaditest.base.BaseRepository;
import com.mizardar.shaaditest.model.network.APIResponse;
import com.mizardar.shaaditest.model.network.Result;
import com.mizardar.shaaditest.repository.offline.UserDatabaseHelper;

import java.util.List;

import retrofit2.Response;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserRepository extends BaseRepository {

    private UserAPI userAPI;
    private UserDatabaseHelper userDatabaseHelper;

    public UserRepository(Context context) {
        userAPI = getRetrofitClient().getService(UserAPI.class);
        userDatabaseHelper = new UserDatabaseHelper(context);
    }

    public LiveData<List<Result>> getUsers() {
        Single<Response<APIResponse>> resultObservable = userAPI.getUsersList();
        resultObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(userResult -> {
            if (!userResult.isSuccessful()) {
                Log.i("Repository", "not respond");
            } else {
                userDatabaseHelper.save(userResult.body().getResults());
            }
        }, throwable -> Log.i("Repository", throwable.getMessage()));

        return userDatabaseHelper.getAll();
    }

    public void updateUser(Result user){
        userDatabaseHelper.update(user);
    }


    public Result getUser(String email){
        return userDatabaseHelper.getUser(email);
    }
}
