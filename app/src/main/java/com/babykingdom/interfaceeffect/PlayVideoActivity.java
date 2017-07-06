package com.babykingdom.interfaceeffect;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.babykingdom.interfaceeffect.widget.FullScreenVideoView;

public class PlayVideoActivity extends AppCompatActivity {

    private FullScreenVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
//        videoView = (FullScreenVideoView) findViewById(R.id.videoView);
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//
//        videoView.setVideoURI(Uri.parse("android.resource://com.babykingdom.interfaceeffect/" + R.raw.firework));
//        videoView.start();
    }
}
