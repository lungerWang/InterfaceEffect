package com.babykingdom.interfaceeffect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.MediaController;

/**
 * Created by Lunger on 2017/7/26.
 */

public class MyMediaController extends MediaController {

    private onShowAndHide listener;

    public MyMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    public MyMediaController(Context context) {
        super(context);
    }

    public void setOnShowListener(onShowAndHide listener){
        this.listener = listener;
    }

    @Override
    public void hide() {
        super.hide();
        if(listener != null){
            listener.onHide();
        }
    }

    @Override
    public void show(int timeout) {
        super.show(timeout);
        if(listener != null){
            listener.onShow();
        }
    }

    public interface onShowAndHide{
        void onShow();
        void onHide();
    }



}
