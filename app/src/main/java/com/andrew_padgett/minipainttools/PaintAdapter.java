package com.andrew_padgett.minipainttools;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaintAdapter extends RecyclerView.Adapter<PaintAdapter.PaintViewHolder> {

    private ModelPaint[] mData;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mClickListener;

    // Pass data into the constructor
    PaintAdapter(Context context, ModelPaint[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // Inflate card layout from xml when needed
    @NonNull
    @Override
    public PaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.paint_color_item_alt, parent, false);
        return new PaintViewHolder(view);
    }

    // Bind data to each View in card layout
    @Override
    public void onBindViewHolder(@NonNull PaintViewHolder holder, int position) {
        ModelPaint modelPaint = mData[position];
        String paintName = modelPaint.getName();
        String manufacturer = modelPaint.getManufacturer();
        @ColorInt int paintColor = modelPaint.getPaintColor();
        String hexCode = String.format("#%06X", (0xFFFFFF & paintColor));

        holder.paintNameTextView.setText(paintName);
        holder.manufacturerTextView.setText(manufacturer);
        holder.hexCodeTextView.setText(hexCode);
        holder.colorView.setBackgroundColor(paintColor);
    }

    // Total number of card views
    @Override
    public int getItemCount() {
        return mData.length;
    }


    // Store and recycle views as they scroll off screen
    public class PaintViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView paintNameTextView;
        public TextView manufacturerTextView;
        public TextView hexCodeTextView;
        public View colorView;

        public PaintViewHolder(View itemView) {
            super(itemView);
            paintNameTextView = itemView.findViewById(R.id.tv_paint_name);
            manufacturerTextView = itemView.findViewById(R.id.tv_manufacturer);
            hexCodeTextView = itemView.findViewById(R.id.tv_hex_code);
            colorView = itemView.findViewById(R.id.color_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClick(view, getAdapterPosition());
        }
    }

    // Convenience method for getting data at click position
    public String getItem(int id) {
        return mData[id].getName();
    }

    // Method that executes following code for action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked paint name " + getItem(position).toString() + ", which is at position " + position);
        }

}
