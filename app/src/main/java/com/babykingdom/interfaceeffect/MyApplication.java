package com.babykingdom.interfaceeffect;

import android.app.Application;

/**
 * Created by Lunger on 2017/8/21 0021.
 */

public class MyApplication extends Application{

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance(){
        return instance;
    }
}
