package com.sunguyi.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sunguyi.myapplication.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<News_item> newsList;


    public NewsAdapter(List<News_item> newsList) {
        this.newsList = newsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_news_first_item, parent, false);
        final NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(view);
        //新建一个viewHolder绑定解析到的view
        //监听每一项的点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                News_item news_bean = newsList.get(position);

                Intent intent = new Intent(view.getContext(), NewsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("src", news_bean.getNews_url());
                bundle.putString("news_title", news_bean.getTitle());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    //通过getItemViewType的返回值来选择具体的item显示
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        News_item newsItem = newsList.get(position);
        holder.titleTextView.setText(newsItem.getTitle());
        holder.contentTextView.setText(newsItem.getContent());
        Glide.with(holder.imageView).load(newsItem.getImg_url()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView contentTextView;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.finishtitle);
            contentTextView = itemView.findViewById(R.id.finishcontents);
            imageView = itemView.findViewById(R.id.imageView1);
        }
    }
}
