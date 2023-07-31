package com.sunguyi.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.sunguyi.myapplication.R;
import com.sunguyi.myapplication.util.ToastUtil;


public class VideoPlayActivity extends Activity {
    private VideoView video;
    private MediaController mMediaController;
    public int sig;
    private Bundle bundle;
    private TextView video_title;

    private Button dianzan;

    private Button fenxiang;

    private Button shoucang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, 0);
        }
        AudioManager audioManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
//第二步:调用调节音量的方法
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE,
                AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);

        //接收数据
        bundle = this.getIntent().getExtras();
        video_title = findViewById(R.id.video_title);
        video_title.setText(bundle.getString("video_title"));
        String uri = bundle.getString("src");

        video = findViewById(R.id.video_player);

        dianzan = findViewById(R.id.dianzan_button);
        fenxiang = findViewById(R.id.fenxiang_button);
        shoucang = findViewById(R.id.shoucang_button);

        mMediaController = new MediaController(this);
        video.setVideoURI(Uri.parse(uri));
        video.setVideoPath(uri);

        mMediaController.setMediaPlayer(video);
        video.setMediaController(mMediaController);
        video.start();
        sig = 1;


        dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(getApplicationContext(), "点赞成功");
            }
        });
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(getApplicationContext(), "收藏成功");
            }
        });
        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(getApplicationContext(), "分享成功");
            }
        });


        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(VideoPlayActivity.this, VideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("flag", 2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


}
