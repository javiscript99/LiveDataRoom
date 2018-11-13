package com.example.javi.room_livedata_viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Query;

import java.util.List;

public interface ClassDao {
    void insert(ClassEntity userEntity);

    void insertAll(List<ClassEntity> userEntities);

    void deleteAll();

    @Query("SELECT * FROM class_table ORDER BY classid ASC")
    LiveData<List<ClassEntity>> getAllWords();
}