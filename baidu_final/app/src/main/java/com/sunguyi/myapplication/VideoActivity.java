package com.sunguyi.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunguyi.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends Activity {
    private Button main_home_btn;
    private Button main_vedio_btn;
    private  Button main_person_btn;

    private List<video_item> video_List;

    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        RecyclerView recyclerView = findViewById(R.id.v_rc);

        main_home_btn=findViewById(R.id.home_button);
        main_vedio_btn=findViewById(R.id.vedio_button);
        main_person_btn=findViewById(R.id.homepage_button);

        video_List = new ArrayList<>();

        video_item temp1 = new video_item("https://box.nju.edu.cn/f/e52e2f6f33f14ebdb4f4/?dl=1","https://box.nju.edu.cn/f/1f4bfc971b134fe1b81c/?dl=1"
                ,"JoJo石之海第一集","动漫");
        video_List.add(temp1);
        video_item temp2 = new video_item("https://box.nju.edu.cn/f/1d0eb2ba9aa84e14be39/?dl=1","https://box.nju.edu.cn/f/1f4bfc971b134fe1b81c/?dl=1"
                ,"JoJo石之海第二集","电影频道");
        video_List.add(temp2);
        video_item temp3 = new video_item("http://vjs.zencdn.net/v/oceans.mp4","https://box.nju.edu.cn/f/fe70480671074881ad81/?dl=1"
                ,"钢铁侠3","电影频道");
        video_List.add(temp3);
        video_item temp4 = new video_item("http://vjs.zencdn.net/v/oceans.mp4","https://box.nju.edu.cn/f/fe70480671074881ad81/?dl=1"
                ,"美国队长3","电影频道");
        video_List.add(temp4);
        video_item temp5 = new video_item("http://vjs.zencdn.net/v/oceans.mp4","https://box.nju.edu.cn/f/fe70480671074881ad81/?dl=1"
                ,"软件工程与计算2","电影频道");
        video_List.add(temp5);

        videoAdapter = new VideoAdapter(video_List);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(videoAdapter);


        main_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(VideoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        main_person_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(VideoActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });

        main_vedio_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(VideoActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

    }
}