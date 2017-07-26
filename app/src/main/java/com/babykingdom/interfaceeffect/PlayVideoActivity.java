package com.babykingdom.interfaceeffect;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.babykingdom.interfaceeffect.widget.FullScreenVideoView;
import com.babykingdom.interfaceeffect.widget.MyMediaController;

public class PlayVideoActivity extends AppCompatActivity {


    private FullScreenVideoView videoView;
    private SeekBar bar_volume;
    private MyMediaController mediaController;
    private AudioManager audioManager;
    private int streamMaxVolume;
    private int streamVolume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_video);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        streamMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        streamVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        initView();
        initListener();

        mediaController = new MyMediaController(this);
        mediaController.setOnShowListener(new MyMediaController.onShowAndHide() {
            @Override
            public void onShow() {
                Log.d("wbl", "show");
                bar_volume.setVisibility(View.VISIBLE);
            }

            @Override
            public void onHide() {
                Log.d("wbl", "hide");
                bar_volume.setVisibility(View.GONE);
            }
        });

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://com.babykingdom.interfaceeffect/" + R.raw.firework));
        videoView.start();
    }

    private void initListener() {
        bar_volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaController.show(3000);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void initView() {
        videoView = (FullScreenVideoView) findViewById(R.id.videoView);
        bar_volume = (SeekBar) findViewById(R.id.bar_volume);
        bar_volume.setMax(streamMaxVolume);
        bar_volume.setProgress(streamVolume);
    }


}
