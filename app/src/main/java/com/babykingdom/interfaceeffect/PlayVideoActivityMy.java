package com.babykingdom.interfaceeffect;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.babykingdom.interfaceeffect.R;
import com.babykingdom.interfaceeffect.widget.FullScreenVideoView;

import java.util.Formatter;
import java.util.Locale;

public class PlayVideoActivityMy extends AppCompatActivity {


    private FullScreenVideoView videoView;
    private ImageView iv_center;
    private RelativeLayout rl_transparent;
    private TextView time_current;
    private TextView time_total;
    private SeekBar seek_bar_progress;
    Formatter mFormatter;
    StringBuilder mFormatBuilder;
    private boolean isDestroy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_video_my);

        initView();
        initData();
        initListener();
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);

        handler.sendEmptyMessage(0);
        videoView.setVideoURI(Uri.parse("android.resource://com.babykingdom.interfaceeffect/" + R.raw.firework));
        initStartEndTime();
        rl_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = iv_center.getVisibility();
                iv_center.setVisibility(visibility == View.VISIBLE ? View.GONE : View.VISIBLE);
            }
        });

        iv_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                    iv_center.setImageResource(R.mipmap.icon_play);
                } else {
                    videoView.start();
                    iv_center.setImageResource(R.mipmap.icon_stop);
                }
            }
        });
    }

    private void initListener() {

    }

    private void initStartEndTime() {
        time_current.setText(stringForTime(videoView.getCurrentPosition()));
        time_total.setText(stringForTime(videoView.getDuration()));
    }

    private void initData() {
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());

    }

    private void initView() {
        videoView = (FullScreenVideoView) findViewById(R.id.videoView);
        iv_center = (ImageView) findViewById(R.id.iv_center);
        rl_transparent = (RelativeLayout) findViewById(R.id.rl_transparent);
        time_current = (TextView) findViewById(R.id.time_current);
        time_total = (TextView) findViewById(R.id.time_total);
        seek_bar_progress = (SeekBar) findViewById(R.id.seek_bar_progress);

        seek_bar_progress.setMax(1000);
    }


    private String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    /**
     * ViewPager auto scroll task
     */
    private class SwitchTask extends Handler implements Runnable {

        @Override
        public void run() {
            this.sendEmptyMessage(0);
            this.postDelayed(this, 2500);
        }

        public void start() {
            this.removeCallbacks(this);
            this.postDelayed(this, 2500);
        }

        public void stop() {
            this.removeCallbacks(this);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("wbl", "数秒");
            if (!isDestroy) {
                refreshProgress();
                this.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    private void refreshProgress() {
        int position = videoView.getCurrentPosition();
        int duration = videoView.getDuration();
        if (seek_bar_progress != null) {
            if (duration > 0) {
                // use long to avoid overflow
                long pos = 1000L * position / duration;
                seek_bar_progress.setProgress((int) pos);
            }
            int percent = videoView.getBufferPercentage();
            seek_bar_progress.setSecondaryProgress(percent * 10);
        }

        if (time_total != null)
            time_total.setText(stringForTime(duration));
        if (time_current != null)
            time_current.setText(stringForTime(position));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
