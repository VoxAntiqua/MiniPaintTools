package com.andrew_padgett.minipainttools.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ModelPaintDao {

    // define conflict resolution strategy for insertion here
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ModelPaintEntity modelPaintEntity);

    @Query("DELETE FROM paint_table")
    void deleteAll();

    @Query("SELECT * FROM paint_table ORDER BY color ASC")
    LiveData<List<ModelPaintEntity>> getPaintsByColor();

    @Query("SELECT * FROM paint_table ORDER BY name ASC")
    LiveData<List<ModelPaintEntity>> getPaintsByName();
}
