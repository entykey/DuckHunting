package com.example.duckhunting;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.view.View;
import android.content.Context;

import androidx.annotation.NonNull;

public class GameView extends View {
    private int height;
    private Paint paint;
    private Bitmap duck;
    private Rect duckRect;

    // initialize:
    public GameView(Context context, int width, int height) {
        // super context của lớp cha lên
        super(context);
        this.height = height;
        duck = BitmapFactory.decodeResource(getResources(), R.drawable.duck);
        float scale = ((float)width/(duck.getWidth()*5));
        duckRect = new Rect(width-width/5, 0, width, (int)(duck.getHeight()*scale));
        paint = new Paint();
        paint.setColor(0xFF000000);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10.0f);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(0, height, height/10, paint);
        canvas.drawLine(0, height, height/5, height-height/5, paint);
        canvas.drawBitmap(duck, null, duckRect, paint);
    }
}
