package com.example.android.speakingnewsapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.speakingnewsapp.Model.FoodMode;
import com.example.android.speakingnewsapp.Model.ModelForNews;
import com.example.android.speakingnewsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anamika on 7/10/17.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {

    private List<FoodMode> foodModelList;
    Context mContext;

    public FoodListAdapter(Context context, List<FoodMode> foodModelList) {
        mContext = context;
        this.foodModelList = foodModelList;
    }




    @Override
    public FoodListAdapter.FoodListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.emenu_item_row, parent, false);
        return new FoodListAdapter.FoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FoodListAdapter.FoodListViewHolder holder, int position) {
        final FoodMode food = foodModelList.get(position);
        holder.foodTitle.setText(food.getFoodname());
        holder.foodPrice.setText(String.valueOf(food.getFoodprice()));
        holder.totalItem.setText(String.valueOf(food.getTotalContent()));
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.totalItem.setText(Integer.valueOf(holder.totalItem.getText().toString())+1);
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.totalItem.setText(Integer.valueOf(holder.totalItem.getText().toString())-1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodModelList.size();
    }

    public class FoodListViewHolder extends RecyclerView.ViewHolder{
        TextView foodTitle;
        TextView foodPrice;
        ImageButton plusButton;
        ImageButton minusButton;
        TextView totalItem;

        public FoodListViewHolder(View itemView) {
            super(itemView);
            foodPrice = (TextView) itemView.findViewById(R.id.food_price);
            foodTitle = (TextView) itemView.findViewById(R.id.food_name);
            totalItem = (TextView) itemView.findViewById(R.id.toalObject);

            plusButton = (ImageButton) itemView.findViewById(R.id.plus);
            minusButton = (ImageButton) itemView.findViewById(R.id.minus);

        }
    }
}
