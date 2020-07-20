package com.andrew_padgett.minipainttools.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelPaintViewModel extends AndroidViewModel {

    private ModelPaintRepository mRepository;

    private LiveData<List<ModelPaintEntity>> mAllPaintsByColor;
    private LiveData<List<ModelPaintEntity>> mAllPaintsByName;

    public ModelPaintViewModel (Application application) {
        super(application);
        mRepository = new ModelPaintRepository(application);
        mAllPaintsByColor = mRepository.getAllModelPaintsByColor();
        mAllPaintsByName = mRepository.getAllModelPaintsByName();
    }

    LiveData<List<ModelPaintEntity>> getAllPaintsByColor() {return mAllPaintsByColor;}
    LiveData<List<ModelPaintEntity>> getALlPaintsByName() {return mAllPaintsByName;}

    public void insert(ModelPaintEntity modelPaintEntity) {mRepository.insert(modelPaintEntity);}

}