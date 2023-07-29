package com.sunguyi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunguyi.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Button btn_wt;
    private RecyclerView news;
    private Button home_button;
    private Button video_button;
    private Button homepage_button;



    private List<News_item> newsList;

    private NewsAdapter newsAdapter;


    private Button mSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_wt = findViewById(R.id.weather_button);
        news = findViewById(R.id.news);

        home_button = findViewById(R.id.home_button);
        video_button = findViewById(R.id.vedio_button);
        homepage_button = findViewById(R.id.homepage_button);

        mSearchView = findViewById(R.id.searchButton);


        newsList = new ArrayList<>();
        News_item temp1 = new News_item("梅西赢得世界杯", "梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军"
                , "https://box.nju.edu.cn/f/4410d0ea4e724b6b8d5e/?dl=1","https://www.toutiao.com/article/7178839510657499659/?channel=&source=search_tab");
        newsList.add(temp1);
        News_item temp2 = new News_item("梅西赢得世界杯", "梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军梅西率领阿根廷赢得2022卡塔尔世界杯冠军"
                , "https://box.nju.edu.cn/f/4410d0ea4e724b6b8d5e/?dl=1","https://www.toutiao.com/article/7178839510657499659/?channel=&source=search_tab");
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);
        newsList.add(temp2);



        newsAdapter = new NewsAdapter(newsList);
        news.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        news.setAdapter(newsAdapter);




        btn_wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, WeatherPageActivity.class);
                startActivity(intent);
            }
        });

        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });




        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        homepage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        video_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
//三个主键的点击事件

    }
}
