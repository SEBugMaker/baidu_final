package com.sunguyi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunguyi.myapplication.R;

public class HomepageActivity extends Activity {
    private Button home_button;
    private Button video_button;
    private  Button homepage_button;
    private Button logon;

    private Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homepage);



        home_button =findViewById(R.id.home_button);
        video_button =findViewById(R.id.video_button);
        homepage_button =findViewById(R.id.homepage_button);
        logon=findViewById(R.id.person_logo);
        historyButton = findViewById(R.id.button);



        //三个主键的点击事件
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(HomepageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        homepage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(HomepageActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });

        video_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(HomepageActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
//三个主键的点击事件

        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(HomepageActivity.this,LogonActivity.class);
                startActivity(intent);
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                intent=new Intent(HomepageActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

    }
}