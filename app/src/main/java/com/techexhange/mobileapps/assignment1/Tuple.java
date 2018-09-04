package com.techexhange.mobileapps.assignment1;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Tuple {
    private final ImageView image;
    private  int value;
    private  Bitmap bitmap;

    public Tuple(ImageView image, int value, Bitmap bitmap){
        this.image = image;
        this.value = value;
        this.bitmap = bitmap;
    }

    public ImageView getImage(){
        return this.image;
    }

    public int  getValue() {
        return value;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
    public void setBitmap(Bitmap newBitmap){
        this.bitmap = newBitmap;
    }
    public void setValue(int value){this.value=value; }
}
