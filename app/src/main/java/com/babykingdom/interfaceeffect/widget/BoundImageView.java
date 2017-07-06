package com.babykingdom.interfaceeffect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.github.florent37.viewanimator.ViewAnimator;

/**
 * Created by Lunger on 2017/7/6.
 */

public class BoundImageView extends ImageView{
    OnClickListener onClickListener;
    public BoundImageView(Context context) {
        super(context);
    }

    public BoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wbl", "down");
                ViewAnimator
                        .animate(this)
                        .scale(1, 0.85f)
                        .alpha(1, 0.8f)
                        .duration(200)
                        .start();
                break;

            case MotionEvent.ACTION_UP:
                Log.d("wbl", "up");
                ViewAnimator
                        .animate(this)
                        .scale(0.85f, 1)
                        .alpha(0.8f, 1)
                        .duration(200)
                        .start();
                if(onClickListener != null){
                    onClickListener.onClick(this);
                }
                break;
        }
        return true;
    }

    public interface OnClickListener{
        void onClick(View v);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
