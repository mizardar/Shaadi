package com.mizardar.shaaditest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mizardar.shaaditest.model.network.Result;
import com.mizardar.shaaditest.repository.online.UserRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application.getApplicationContext());
    }

    public LiveData<List<Result>> getUsers() {
        return userRepository.getUsers();
    }

    public void updateUser(Result user) {
        userRepository.updateUser(user);
    }

    public Result getUser(String email) {
        return userRepository.getUser(email);
    }
}
