package com.andrew_padgett.minipainttools.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelPaintRepository {

    private ModelPaintDao mModelPaintDao;
    private LiveData<List<ModelPaintEntity>> mAllModelPaintsByColor;
    private LiveData<List<ModelPaintEntity>> mAllModelPaintsByName;

    ModelPaintRepository(Application application) {
        ModelPaintRoomDatabase db = ModelPaintRoomDatabase.getDatabase(application);
        mModelPaintDao = db.modelPaintDao();
        mAllModelPaintsByColor = mModelPaintDao.getPaintsByColor();
        mAllModelPaintsByName = mModelPaintDao.getPaintsByName();
    }

    LiveData<List<ModelPaintEntity>> getAllModelPaintsByColor() {
        return mAllModelPaintsByColor;
    }

    LiveData<List<ModelPaintEntity>> getAllModelPaintsByName() {
        return mAllModelPaintsByName;
    }

    void insert(ModelPaintEntity modelPaintEntity) {
        ModelPaintRoomDatabase.databaseWriteExecutor.execute(() -> {
            mModelPaintDao.insert(modelPaintEntity);
        });
    }

}
