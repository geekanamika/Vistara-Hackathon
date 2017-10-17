package com.example.android.speakingnewsapp.Activities;

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
import android.widget.Button;
import android.widget.Toast;

import com.example.android.speakingnewsapp.Adapters.EMenuAdapter;
import com.example.android.speakingnewsapp.Adapters.FoodListAdapter;
import com.example.android.speakingnewsapp.Model.FoodMode;
import com.example.android.speakingnewsapp.Model.ModelForNews;
import com.example.android.speakingnewsapp.R;

import java.util.ArrayList;
import java.util.List;

public class Food_List extends AppCompatActivity {

    RecyclerView foodListRecyclerview;
    List<FoodMode> foodModelList;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        button = (Button) findViewById(R.id.placeorder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Food_List.this, "Order Placed", Toast.LENGTH_SHORT).show();
            }
        });
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
        Log.d("MainActivity","inside sample data ");
        foodModelList = new ArrayList<FoodMode>();
        FoodMode ob = new FoodMode(100, "Cappuccino Coffee" , 5);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Espresso Coffee",10);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Latte Coffee",0);
        foodModelList.add(ob);
        ob = new FoodMode(180,"Americano Coffee",0);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Orange Juice",0);
        foodModelList.add(ob);
        ob = new FoodMode(150,"Lime Water",0);
        foodModelList.add(ob);
        ob = new FoodMode(120,"Tea",0);
        foodModelList.add(ob);
        ob = new FoodMode(100,"Diet Coke",0);
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
