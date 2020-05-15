package com.andrew_padgett.minipainttools;

import android.graphics.Color;

import androidx.annotation.ColorInt;

/**
 * The ModelPaint class describes a paint used for miniature hobby painting, and is designed to
 * interface with tools for comparing colors and building color schemes using the
 * android.graphics.Color library.
 *
 * @author Andrew Padgett
 * @version 1.0
 */
public final class ModelPaint {
    private String mName;
    private String mManufacturer;
    @ColorInt private int mPaintColor;
    private Boolean mInCollection;
    private Boolean mInWishlist;

    /** Constructor in which inCollection and inWishlist default to false
     *
     * @param name (required) name of the paint - e.g. "German Tank Brown"
     * @param manufacturer (required) name of manufacturer - e.g. "Vallejo Model Air"
     * @param paintColor (required) Color associated with the paint in ARGB integer format
     * */
    public ModelPaint(String name, String manufacturer, @ColorInt int paintColor) {
        this(name, manufacturer, paintColor, false, false);
    }

    /** Constructor in which inCollection and inWishlist are defined
     *
     * @param name (required) name of the paint - e.g. "German Tank Brown"
     * @param manufacturer (required) name of manufacturer - e.g. "Vallejo Model Air"
     * @param paintColor (required) Color associated with the paint in ARGB integer format
     * @param inCollection (optional) whether the paint is in the user's collection
     * @param inWishlist (optional) whether the paint is in the user's wishlist
     */
    public ModelPaint(String name, String manufacturer, @ColorInt int paintColor, Boolean inCollection,
                      Boolean inWishlist) {
        mName = name;
        mManufacturer = manufacturer;
        mPaintColor = paintColor;
        mInCollection = inCollection;
        mInWishlist = inWishlist;
    }

    //Getter methods follow
    public String getName() {
        return mName;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public @ColorInt int getPaintColor() {
        return mPaintColor;
    }

    public Boolean getInCollection() {
        return mInCollection;
    }

    public Boolean getInWishlist() {
        return mInWishlist;
    }

    //Setter methods follow
    public void setName(String name) {
        mName = name;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }

    public void setPaintColor(@ ColorInt int paintColor) {
        mPaintColor = paintColor;
    }

    public void setInCollection(Boolean inCollection) {
        mInCollection = inCollection;
    }

    public void setInWishlist(Boolean inWishlist) {
        mInWishlist = inWishlist;
    }


}
