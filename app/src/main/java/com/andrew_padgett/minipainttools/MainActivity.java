package com.andrew_padgett.minipainttools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PaintAdapter.OnPaintClickListener {

    PaintAdapter adapter;
    ArrayList<ModelPaint> data = new ArrayList<ModelPaint>();
    Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_paint_collection);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_paint_grid);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        final PaintAdapter adapter = new PaintAdapter(this, this);
        recyclerView.setAdapter(adapter);

    }

    // Define on click behavior for each card
    @Override
    public void onPaintClick(int position) {
        if (toast != null) toast.cancel();
        // Toggle whether paint is in collection and update
        if (data.get(position).getInCollection()) {
            data.get(position).setInCollection(Boolean.FALSE);
            toast = Toast.makeText(this, data.get(position).getName() + " removed from collection.", Toast.LENGTH_LONG);
        } else {
            data.get(position).setInCollection(Boolean.TRUE);
            toast = Toast.makeText(this, data.get(position).getName() + " added to collection.", Toast.LENGTH_LONG);
        }
        toast.show();
        adapter.notifyItemChanged(position);

    }
}
