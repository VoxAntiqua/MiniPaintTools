package com.andrew_padgett.minipainttools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.andrew_padgett.minipainttools.data.ModelPaint;
import com.andrew_padgett.minipainttools.data.ModelPaintViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PaintAdapter adapter;
    Toast toast = null;

    private ModelPaintViewModel mModelPaintViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_paint_collection);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_paint_grid);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        final PaintAdapter adapter = new PaintAdapter(this);
        recyclerView.setAdapter(adapter);

        mModelPaintViewModel = new ViewModelProvider(this).get(ModelPaintViewModel.class);

        mModelPaintViewModel.getAllModelPaintsByColor().observe(this, new Observer<List<ModelPaint>>() {
            @Override
            public void onChanged(List<ModelPaint> modelPaintEntities) {
                adapter.setPaints(modelPaintEntities);
            }
        });

    }

//    // Define on click behavior for each card
//    @Override
//    public void onPaintClick(int position) {
//        if (toast != null) toast.cancel();
//        // Toggle whether paint is in collection and update
//        if (data.get(position).getInCollection()) {
//            data.get(position).setInCollection(Boolean.FALSE);
//            toast = Toast.makeText(this, data.get(position).getName() + " removed from collection.", Toast.LENGTH_LONG);
//        } else {
//            data.get(position).setInCollection(Boolean.TRUE);
//            toast = Toast.makeText(this, data.get(position).getName() + " added to collection.", Toast.LENGTH_LONG);
//        }
//        toast.show();
//        adapter.notifyItemChanged(position);
//
//    }
}
