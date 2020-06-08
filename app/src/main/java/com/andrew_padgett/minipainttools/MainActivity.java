package com.andrew_padgett.minipainttools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PaintAdapter.OnPaintClickListener {

    PaintAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_paint_collection);

        // test data to populate RecyclerView
        ModelPaint modelPaintPlaceHolder01 = new ModelPaint("Flash Gitz Yellow", "Citadel", Color.parseColor("#ffee00"));
        ModelPaint modelPaintPlaceHolder02 = new ModelPaint("Bright Orange", "Vallejo", Color.parseColor("#f26833"));
        ModelPaint modelPaintPlaceHolder03 = new ModelPaint("Khador Red Base", "P3 Formula", Color.parseColor("#ee2824"));
        ModelPaint modelPaintPlaceHolder04 = new ModelPaint("Screamer Pink", "Citadel", Color.parseColor("#831740"));
        ModelPaint modelPaintPlaceHolder05 = new ModelPaint("Hexed Lichen", "Vallejo", Color.parseColor("#34274d"));
        ModelPaint modelPaintPlaceHolder06 = new ModelPaint("Ironhull Grey", "P3 Formula", Color.parseColor("#8e969b"));
        ModelPaint modelPaintPlaceHolder07 = new ModelPaint("Macragge Blue", "Citadel", Color.parseColor("#14397a"));
        ModelPaint modelPaintPlaceHolder08 = new ModelPaint("Sotek Green", "Citadel", Color.parseColor("#056976"));
        ModelPaint modelPaintPlaceHolder09 = new ModelPaint("Sybarite Green", "Citadel", Color.parseColor("#36a062"));
        ModelPaint modelPaintPlaceHolder10 = new ModelPaint("Waaagh! Flesh", "Citadel", Color.parseColor("#275627"));
        ModelPaint modelPaintPlaceHolder11 = new ModelPaint("Screaming Skull", "Citadel", Color.parseColor("#d9d8a6"));
        ModelPaint modelPaintPlaceHolder12 = new ModelPaint("Tallarn Sand", "Citadel", Color.parseColor("#ab7d00"));
        ModelPaint modelPaintPlaceHolder13 = new ModelPaint("Bestigor Flesh", "Citadel", Color.parseColor("#D38A57"));
        ModelPaint modelPaintPlaceHolder14 = new ModelPaint("Skrag Brown", "Citadel", Color.parseColor("#954b00"));
        ModelPaint modelPaintPlaceHolder15 = new ModelPaint("Rhinox Hide", "Citadel", Color.parseColor("#4e3433"));
        ModelPaint modelPaintPlaceHolder16 = new ModelPaint("Administratum Grey", "Citadel", Color.parseColor("#9da299"));
        ModelPaint modelPaintPlaceHolder17 = new ModelPaint("Abaddon Black", "Citadel", Color.parseColor("#010100"));
        ModelPaint modelPaintPlaceHolder18 = new ModelPaint("Baharroth Blue", "Citadel", Color.parseColor("#58C1CD"));
        ModelPaint modelPaintPlaceHolder19 = new ModelPaint("Blue Horror", "Citadel", Color.parseColor("#A2BAD2"));
        ModelPaint modelPaintPlaceHolder20 = new ModelPaint("Dechala Lilac", "Citadel", Color.parseColor("#B69FCC"));
        ModelPaint[] data = {modelPaintPlaceHolder01,
                modelPaintPlaceHolder02,
                modelPaintPlaceHolder03,
                modelPaintPlaceHolder04,
                modelPaintPlaceHolder05,
                modelPaintPlaceHolder06,
                modelPaintPlaceHolder07,
                modelPaintPlaceHolder08,
                modelPaintPlaceHolder09,
                modelPaintPlaceHolder10,
                modelPaintPlaceHolder11,
                modelPaintPlaceHolder12,
                modelPaintPlaceHolder13,
                modelPaintPlaceHolder14,
                modelPaintPlaceHolder15,
                modelPaintPlaceHolder16,
                modelPaintPlaceHolder17,
                modelPaintPlaceHolder18,
                modelPaintPlaceHolder19,
                modelPaintPlaceHolder20};

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_paint_grid);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new PaintAdapter(this, data, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onPaintClick(int position) {
        Toast toast = Toast.makeText(this, position + " clicked!", Toast.LENGTH_LONG);
        toast.show();
    }
}
