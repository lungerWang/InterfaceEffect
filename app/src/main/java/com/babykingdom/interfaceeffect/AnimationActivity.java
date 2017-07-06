package com.babykingdom.interfaceeffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.florent37.viewanimator.ViewAnimator;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
//        ViewAnimator
//                .animate(tv2)
//                .translationY(-1000, 0)
//                .alpha(0,1)
//                .andAnimate(text)
//                .dp().translationX(-20, 0)
//                .decelerate()
//                .duration(2000)
//                .thenAnimate(tv2)
//                .scale(1f, 0.5f, 1f)
//                .accelerate()
//                .duration(1000)
//                .start();
    }
}
