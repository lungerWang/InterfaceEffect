package com.babykingdom.interfaceeffect;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import com.babykingdom.interfaceeffect.widget.BoundImageView;
import com.github.florent37.viewanimator.ViewAnimator;

public class QianhaiActivity extends AppCompatActivity {

    private BoundImageView iv1;
    private View iv2;
    private View iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qianhai);
        findViews();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iv1.setVisibility(View.VISIBLE);
            }
        }, 0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iv2.setVisibility(View.VISIBLE);
            }
        }, 250);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iv3.setVisibility(View.VISIBLE);
            }
        }, 600);
        ViewAnimator
                .animate(iv1)
                .scale(0, 1)
                .duration(500)
                .startDelay(0)
                .start();
        ViewAnimator
                .animate(iv2)
                .scale(0, 1)
                .duration(500)
                .startDelay(200)
                .start();
        ViewAnimator
                .animate(iv3)
                .scale(0, 1)
                .duration(500)
                .startDelay(300)
                .start();
    }

    private void findViews() {
        iv1 = (BoundImageView) findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv1.setOnClickListener(new BoundImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("wbl", "被点击了");
                startActivity(new Intent(QianhaiActivity.this, PlayVideoActivity.class));
            }
        });

    }
}
