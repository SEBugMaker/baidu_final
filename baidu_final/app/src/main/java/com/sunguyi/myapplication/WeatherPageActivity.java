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

public class WeatherPageActivity extends Activity {
    private WeatherAdapter adapter;

    private List<Weather_Item> weatherList;

    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        back_button =findViewById(R.id.back_home);
        //RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView recyclerView1=findViewById(R.id.recyclerView1);

        Button button = findViewById(R.id.back_home);
        button.getBackground().setAlpha(200);


        /**
         * 超过24h需要特殊判断
         */
        weatherList = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            Weather_Item weatherItem;
            switch(i) {
                case 1:
                    weatherItem = new Weather_Item("12:00", "21°C", R.drawable.dayu);
                    weatherList.add(weatherItem);
                    break;
                case 2:
                    weatherItem = new Weather_Item("13:00", "21°C", R.drawable.duoyun);
                    weatherList.add(weatherItem);
                    break;
                case 3:
                    weatherItem = new Weather_Item("14:00", "25°C", R.drawable.wuqi);
                    weatherList.add(weatherItem);
                    break;
                case 4:
                    weatherItem = new Weather_Item("15:00", "28°C", R.drawable.lieri);
                    weatherList.add(weatherItem);
                    break;
                case 5:
                    weatherItem = new Weather_Item("16:00", "30°C", R.drawable.lieri);
                    weatherList.add(weatherItem);
                    break;
                case 6:
                    weatherItem = new Weather_Item("17:00", "32°C", R.drawable.duoyun);
                    weatherList.add(weatherItem);
                    break;
                case 7:
                    weatherItem = new Weather_Item("18:00", "30°C", R.drawable.duoyun);
                    weatherList.add(weatherItem);
                    break;
                default:
                    String time;
                    if(12+i>24){
                        time = String.valueOf(12+i-24);
                    }else{
                        time = String.valueOf(12+i);
                    }
                    Weather_Item weatherItem_default = new Weather_Item(time+":00", "29°C", R.drawable.wuqi);
                    weatherList.add(weatherItem_default);

            }

        }

        adapter = new WeatherAdapter(weatherList);


        // 设置24小时天气预报的RecyclerView的布局管理器和适配器
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setAdapter(adapter);

//点击天气界面返回键返回主界面
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                intent=new Intent(WeatherPageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
////////////

    }
}
