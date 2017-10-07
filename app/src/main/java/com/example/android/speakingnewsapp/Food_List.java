package com.example.android.speakingnewsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.speakingnewsapp.Adapters.EMenuAdapter;
import com.example.android.speakingnewsapp.Adapters.FoodListAdapter;
import com.example.android.speakingnewsapp.Model.FoodMode;
import com.example.android.speakingnewsapp.Model.ModelForNews;

import java.util.ArrayList;
import java.util.List;

public class Food_List extends AppCompatActivity {

    RecyclerView foodListRecyclerview;
    List<FoodMode> foodModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // Toast.makeText(this, "" + EMenuAdapter.pos, Toast.LENGTH_SHORT).show();

        foodListRecyclerview = (RecyclerView) findViewById(R.id.food_list_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        createSampleFoodData();
        foodListRecyclerview.setLayoutManager(layoutManager);
        foodListRecyclerview.setItemAnimator(new DefaultItemAnimator());
        foodListRecyclerview.setHasFixedSize(true);

        FoodListAdapter  foodListAdapter= new FoodListAdapter(this,foodModelList);
       // FoodListAdapter.notifyDataSetChanged();
        foodListAdapter.notifyDataSetChanged();

        foodListRecyclerview.setAdapter(foodListAdapter);


    }

    private void createSampleFoodData() {
        Log.d("MainActivit","inside sample data ");
        foodModelList = new ArrayList<FoodMode>();
        FoodMode ob = new FoodMode(100, "Pepsi" , 5);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Lassi",10);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Pepsi",0);
        foodModelList.add(ob);
        ob = new FoodMode(180,"Juice",0);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Coffee",0);
        foodModelList.add(ob);
        ob = new FoodMode(150,"Tea",0);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Cocola",0);
        foodModelList.add(ob);
        ob = new FoodMode(100,"Drink",0);
        foodModelList.add(ob);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.action_safety) {
            Toast.makeText(this, "implement", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
