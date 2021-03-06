package com.babykingdom.interfaceeffect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonEffect(View view) {
        startActivity(new Intent(this, ButtonActivity.class));
    }

    public void animationEffect(View view) {
        startActivity(new Intent(this, AnimationActivity.class));
    }

    public void qianhaiClick(View view) {
        startActivity(new Intent(this, QianhaiActivity.class));
    }

    public void integration(View view) {
        startActivity(new Intent(this, IntegrationActivity.class));
    }
}
