package com.mizardar.shaaditest.repository.offline;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.mizardar.shaaditest.base.BaseDao;
import com.mizardar.shaaditest.model.network.Result;

import java.util.List;

@Dao
public interface UserDao extends BaseDao<Result> {

    @Query("select * from Result")
    LiveData<List<Result>> getAll();

    @Query("select * from Result where email = :email")
    Result getUser(String email);

    @Update()
    void update(Result result);
}
