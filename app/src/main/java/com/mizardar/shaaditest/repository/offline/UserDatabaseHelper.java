package com.mizardar.shaaditest.repository.offline;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mizardar.shaaditest.base.BaseDatabaseHelper;
import com.mizardar.shaaditest.model.network.Result;

import java.util.List;

public class UserDatabaseHelper extends BaseDatabaseHelper {

    private UserDao userDao;

    public UserDatabaseHelper(Context context) {
        super(context);
        userDao = appDatabase.getUserDao();
    }

    public LiveData<List<Result>> getAll() {
        return userDao.getAll();
    }

    public Result getUser(String email) {
        return userDao.getUser(email);
    }

    public void save(List<Result> users) {
        userDao.insert(users);
    }

    public void update(Result users) {
        userDao.update(users);
    }
}
