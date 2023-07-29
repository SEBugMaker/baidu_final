package com.sunguyi.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.sunguyi.myapplication.R;

public class LoginActivity extends Activity {

    private TextView name;
    private SharedPreferences sharedPreferences;

    private ImageView image;

    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_log_success);

        name = findViewById(R.id.textView2);
        back = findViewById(R.id.button4);
        image = findViewById(R.id.imageView);
        sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        String username = intent.getStringExtra("name");

        name.setText("用户姓名：" + username);
        Glide.with(image).load("https://box.nju.edu.cn/f/4410d0ea4e724b6b8d5e/?dl=1").into(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(LoginActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

    }


}