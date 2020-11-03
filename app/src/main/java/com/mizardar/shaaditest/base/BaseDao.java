package com.mizardar.shaaditest.base;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Update;

import com.mizardar.shaaditest.model.network.Result;

import java.util.List;

import rx.Single;

import static androidx.room.OnConflictStrategy.REPLACE;

public interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    void insert(T t);

    @Insert(onConflict = REPLACE)
    void insert(List<T> t);
}
