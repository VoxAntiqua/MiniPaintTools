package com.andrew_padgett.minipainttools.data;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * The ModelPaint class describes a paint used for miniature hobby painting, and is designed
 * to interface with tools for comparing colors and building color schemes using the
 * android.graphics.Color library.
 *
 * @author Andrew Padgett
 * @version 1.0
 */

@Entity(tableName = "paint_table")
public class ModelPaint {

    @PrimaryKey(autoGenerate = true)
    private int id=0;

    @NonNull
    @ColumnInfo(name="name")
    private String mName;

    @NonNull
    @ColumnInfo(name="manufacturer")
    private String mManufacturer;

    @NonNull
    @ColumnInfo(name="color")
    @ColorInt private int mColor;

    @NonNull
    @ColumnInfo(name="in_collection", defaultValue = "0")
    private int mInCollection;

    @NonNull
    @ColumnInfo(name="in_wishlist", defaultValue = "0")
    private int mInWishlist;

    public ModelPaint(int id,
                      String name,
                      String manufacturer,
                      @ColorInt int color,
                      int inCollection,
                      int inWishlist) {
        this.id = id;
        this.mName = name;
        this.mManufacturer = manufacturer;
        this.mColor = color;
        this.mInCollection = inCollection;
        this.mInWishlist = inWishlist;
    }

    @Ignore
    public ModelPaint(String name,
                      String manufacturer,
                      @ColorInt int color,
                      int inCollection,
                      int inWishlist) {
        this.mName = name;
        this.mManufacturer = manufacturer;
        this.mColor = color;
        this.mInCollection = inCollection;
        this.mInWishlist = inWishlist;
    }

    public String getName() { return this.mName; }
    public String getManufacturer(){return this.mManufacturer;}
    public @ColorInt int getColor(){return this.mColor;}
    public int getInCollection(){return this.mInCollection;}
    public int getInWishlist(){return this.mInWishlist;}
    public int getId(){return id;}

    public void setInCollection(int inCollection){mInCollection = inCollection;}
    public void setInWishlist(int inWishlist){mInWishlist = inWishlist;}

}
