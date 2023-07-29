package com.sunguyi.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

public class WebActivity extends Activity {
    private Button backButton;

    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        Intent intent =getIntent();
        String target = intent.getStringExtra("target");

        backButton = findViewById(R.id.button_back);
        webView = findViewById(R.id.web_view);
        //System.out.println(target);
        webView.loadUrl("http://www.baidu.com/s?wd="+target);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                intent=new Intent(WebActivity.this,SearchActivity.class);
                intent.putExtra("history",target);
                startActivity(intent);
            }
        });

    }
}
