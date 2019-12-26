package com.michelle.smallgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class GameView extends View {
    private float posX,posY = 0;

    public GameView (Context context,@Nullable AttributeSet attrs){
        super(context,attrs);
    }
    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bt21);
        canvas.drawBitmap(bitmap,posX,posY,paint);
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (0 < posX && posX< getWidth() - 750) {
            this.posX = posX;
        }
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        if (0 < posY && posY < getHeight() - 680)
        this.posY = posY;
    }
}
