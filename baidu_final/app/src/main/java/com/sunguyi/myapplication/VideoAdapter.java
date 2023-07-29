package com.sunguyi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.sunguyi.myapplication.R;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<video_item> videoList;

    public VideoAdapter(List<video_item> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        final VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);//新建一个viewHolder绑定解析到的view
        //监听每一项的点击事件
        viewHolder.contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                video_item video_bean = videoList.get(position);

                Intent intent = new Intent(view.getContext(), VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("src", video_bean.getVideo_src());
                bundle.putString("video_title", video_bean.getVideo_title());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        video_item video_item = videoList.get(position);
        holder.video_title.setText(video_item.getVideo_title());
        holder.username.setText(video_item.getUsername());
        Glide.with(holder.video).load(video_item.getVideo_img()).into(holder.video);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View contactView;//存储解析到的view
        ImageView video;
        TextView video_title;
        TextView username;
        TextView tip;

        public ViewHolder(View view) {
            super(view);
            contactView = view;
            video_title = view.findViewById(R.id.video_title);
            username = view.findViewById(R.id.username);
            video = view.findViewById(R.id.video);
        }
    }
}
