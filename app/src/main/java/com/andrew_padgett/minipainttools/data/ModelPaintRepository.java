package com.andrew_padgett.minipainttools.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelPaintRepository {

    private ModelPaintDao mModelPaintDao;
    private LiveData<List<ModelPaint>> mAllModelPaintsByColor;
    private LiveData<List<ModelPaint>> mAllModelPaintsByName;

    ModelPaintRepository(Application application) {
        ModelPaintRoomDatabase db = ModelPaintRoomDatabase.getDatabase(application);
        mModelPaintDao = db.modelPaintDao();
        mAllModelPaintsByColor = mModelPaintDao.getPaintsByColor();
        mAllModelPaintsByName = mModelPaintDao.getPaintsByName();
    }

    LiveData<List<ModelPaint>> getAllModelPaintsByColor() {
        return mAllModelPaintsByColor;
    }

    LiveData<List<ModelPaint>> getAllModelPaintsByName() {
        return mAllModelPaintsByName;
    }

    void insert(ModelPaint modelPaint) {
        ModelPaintRoomDatabase.databaseWriteExecutor.execute(() -> {
            mModelPaintDao.insert(modelPaint);
        });
    }

}
