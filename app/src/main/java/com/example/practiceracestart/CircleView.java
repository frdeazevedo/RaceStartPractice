package com.example.practiceracestart;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

public class CircleView extends View {
    private String colorHex;
    private final Paint drawPaint;
    private float size;

    public CircleView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        this.colorHex = "#000000";

        drawPaint = new Paint();
        drawPaint.setColor(Color.parseColor(this.colorHex));
        drawPaint.setAntiAlias(true);

        setOnMeasureCallback();
    }

    public void setColor(String colorHex) {
        this.colorHex = colorHex;
        this.drawPaint.setColor(Color.parseColor(this.colorHex));
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(size, size, size, drawPaint);
    }

    private void setOnMeasureCallback() {
        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                removeOnGlobalLayoutListener(this);
                size = getMeasuredWidth() / 2;
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void removeOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener listener) {
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(listener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        }
    }
}