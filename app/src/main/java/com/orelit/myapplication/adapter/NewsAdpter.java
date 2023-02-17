package com.orelit.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.orelit.myapplication.R;
import com.orelit.myapplication.dto.ScienceNewsDTO;

import java.util.ArrayList;

public class NewsAdpter extends RecyclerView.Adapter<NewsAdpter.NewsAdpterViewHolder> {

    Context context;
    ArrayList<ScienceNewsDTO.Data> mData;
    int size;

    public NewsAdpter(Context context, ArrayList<ScienceNewsDTO.Data> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsAdpterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.home_list_item, parent,false);
        return new NewsAdpter.NewsAdpterViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdpterViewHolder holder, int position) {
        holder.tv_personal_acc.setText(mData.get(position).getContent());
        holder.textView2.setText(mData.get(position).getAuthor());

        Glide.with(context)
                .load(mData.get(position).getImageUrl())
                .placeholder(R.drawable.icon)
                .into(holder.ic_personal_acc);

    }


    @Override
    public int getItemCount() {
        try{
            size = mData.size();
        }catch (Exception e){

        }
        return size;
    }

    public class NewsAdpterViewHolder extends RecyclerView.ViewHolder{

        TextView tv_personal_acc,textView2;
        ImageView ic_personal_acc;

        public NewsAdpterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_personal_acc = itemView.findViewById(R.id.tv_personal_acc);
            textView2 = itemView.findViewById(R.id.textView2);
            ic_personal_acc = itemView.findViewById(R.id.ic_personal_acc);

        }
    }
}
