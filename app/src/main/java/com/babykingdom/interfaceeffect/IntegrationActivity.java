package com.babykingdom.interfaceeffect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.babykingdom.interfaceeffect.util.BarUtils;

/**
 * 状态栏一体化
 */
public class IntegrationActivity extends Activity {

    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integration);
        BarUtils.setStatusBar4Bg(IntegrationActivity.this, 0);

    }

    public void change(View view) {
        if(!flag){
            BarUtils.setStatusBarColor(this, Color.parseColor("#000000"));
        }else{
            BarUtils.setStatusBar4Bg(IntegrationActivity.this, 0);
        }
        flag = !flag;

    }
}
