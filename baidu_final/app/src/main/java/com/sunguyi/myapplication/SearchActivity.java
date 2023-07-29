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

import java.util.Vector;

public class SearchActivity extends Activity {
    private SearchView mSearchView;
    private ListView mListView;
    private ArrayAdapter mAdapter;

    private String info;
    private Button home_button;
    private Button video_button;
    private Button homepage_button;
    private String [] data = {"Java","kotlin","C","C++","C#","Python","PHP","JavaScript"};

    private Vector<String> historyList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        historyList = new Vector<String>();

        Intent intent =getIntent();
        String target = intent.getStringExtra("history");
        if(target!=null){
            historyList.add(target);
        }

        historyList.add("Java");
        historyList.add("C");
        historyList.add("Football");
        historyList.add("体育赛事");
        historyList.add("baidu the best");

        home_button = findViewById(R.id.home_button);
        video_button = findViewById(R.id.vedio_button);
        homepage_button = findViewById(R.id.homepage_button);
        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new ArrayAdapter(SearchActivity.this, android.R.layout.simple_list_item_1, historyList.toArray());
        mListView.setAdapter(mAdapter);
        mListView.setTextFilterEnabled(true);

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(SearchActivity.this,WebActivity.class);
                intent.putExtra("target",query);
                startActivity(intent);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    info = newText;         //  newText输入搜索框的值
                    mListView.setFilterText(newText);
                }else{

                    mListView.clearTextFilter();
                }
                return false;
            }
        });

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        homepage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(SearchActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        video_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(SearchActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
