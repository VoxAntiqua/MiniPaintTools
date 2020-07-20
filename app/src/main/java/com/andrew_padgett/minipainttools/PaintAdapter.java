package com.andrew_padgett.minipainttools;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.andrew_padgett.minipainttools.data.ModelPaintEntity;

import java.util.ArrayList;
import java.util.List;

public class PaintAdapter extends RecyclerView.Adapter<PaintAdapter.PaintViewHolder> {

    private LayoutInflater mInflater;
    private OnPaintClickListener mOnPaintClickListener;

    private List<ModelPaintEntity> mData; // Cached copy of model paints

    // Pass data into the constructor
    PaintAdapter(Context context, OnPaintClickListener onPaintClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mOnPaintClickListener = onPaintClickListener;
    }

    // Inflate card layout from xml when needed
    @NonNull
    @Override
    public PaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.paint_color_item_alt, parent, false);
        return new PaintViewHolder(view, mOnPaintClickListener);
    }

    // Bind data to each View in card layout
    @Override
    public void onBindViewHolder(@NonNull PaintViewHolder holder, int position) {

        if (mData != null) {
            ModelPaintEntity current = mData.get(position);
            holder.paintNameTextView.setText(current.getName());
            holder.manufacturerTextView.setText(current.getManufacturer());
            @ColorInt int paintColor = current.getColor();
            String hexCode = String.format("#%06X", (0xFFFFFF & paintColor));
            holder.hexCodeTextView.setText(hexCode);
            holder.colorView.setBackgroundColor(paintColor);
            if (current.getInCollection() == 0) {
                holder.inCollectionIcon.setVisibility(View.INVISIBLE);
            } else {
                holder.inCollectionIcon.setVisibility(View.VISIBLE);
            }
        } else {
            holder.paintNameTextView.setText("No paints added");
        }
    }

    // Total number of card views
    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else return 0;
    }


    // Store and recycle views as they scroll off screen
    public class PaintViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView paintNameTextView;
        public TextView manufacturerTextView;
        public TextView hexCodeTextView;
        public View colorView;
        public ImageView inCollectionIcon;
        OnPaintClickListener onPaintClickListener;

        public PaintViewHolder(View itemView, OnPaintClickListener onPaintClickListener) {
            super(itemView);
            paintNameTextView = itemView.findViewById(R.id.tv_paint_name);
            manufacturerTextView = itemView.findViewById(R.id.tv_manufacturer);
            hexCodeTextView = itemView.findViewById(R.id.tv_hex_code);
            colorView = itemView.findViewById(R.id.color_view);
            inCollectionIcon = itemView.findViewById(R.id.in_collection_check);
            this.onPaintClickListener = onPaintClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPaintClickListener.onPaintClick(getAdapterPosition());
        }
    }

    public interface OnPaintClickListener{
        void onPaintClick(int position);
    }

    void setPaints(List<ModelPaintEntity> paints) {
        mData = paints;
        notifyDataSetChanged();
    }

}
