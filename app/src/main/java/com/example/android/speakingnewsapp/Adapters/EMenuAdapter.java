package com.example.android.speakingnewsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.speakingnewsapp.Activities.Food_List;
import com.example.android.speakingnewsapp.Model.ModelForNews;
import com.example.android.speakingnewsapp.R;

import java.util.List;

public class EMenuAdapter extends RecyclerView.Adapter<EMenuAdapter.MyViewHolder> {
    private Context context;
    private List<ModelForNews> modelForNewsList;
    public static int pos;

    public EMenuAdapter(Context mContext, List<ModelForNews> list) {
        context = mContext;
        modelForNewsList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ModelForNews news = modelForNewsList.get(position);
        pos = position;
        Log.d("menuPosition",""+position);
        holder.headlines.setText(news.getHeadline());
        //holder.headlineImage.setImageResource(news.getImage());

        Glide.with(context).load(news.getImage()).into(holder.headlineImage);

    }

    @Override
    public int getItemCount() {
        return modelForNewsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView headlineImage;
        TextView headlines;

        public MyViewHolder(View itemView) {
            super(itemView);
            headlineImage = (ImageView) itemView.findViewById(R.id.newImage);
            headlines = (TextView) itemView.findViewById(R.id.headlines);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    context.startActivity(new Intent(context, Food_List.class));

                }
            });

        }
    }


}