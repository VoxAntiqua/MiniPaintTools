package com.andrew_padgett.minipainttools.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelPaintViewModel extends AndroidViewModel {

    private ModelPaintRepository mRepository;

    private LiveData<List<ModelPaint>> mAllPaintsByColor;
    private LiveData<List<ModelPaint>> mAllPaintsByName;

    public ModelPaintViewModel (Application application) {
        super(application);
        mRepository = new ModelPaintRepository(application);
        mAllPaintsByColor = mRepository.getAllModelPaintsByColor();
        mAllPaintsByName = mRepository.getAllModelPaintsByName();
    }

    public LiveData<List<ModelPaint>> getAllModelPaintsByColor() {return mAllPaintsByColor;}
    public LiveData<List<ModelPaint>> getAllModelPaintsByName() {return mAllPaintsByName;}

    public void insert(ModelPaint modelPaint) {mRepository.insert(modelPaint);}

}
