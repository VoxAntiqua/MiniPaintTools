package com.andrew_padgett.minipainttools.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModelPaintEntity.class}, version = 1, exportSchema = false)
public abstract class ModelPaintRoomDatabase extends RoomDatabase {

    public abstract ModelPaintDao modelPaintDao();

    private static volatile ModelPaintRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ModelPaintRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ModelPaintRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ModelPaintRoomDatabase.class, "model_paint_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
