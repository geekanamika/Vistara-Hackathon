package com.example.android.speakingnewsapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.speakingnewsapp.Adapters.EMenuAdapter;
import com.example.android.speakingnewsapp.Model.ModelForNews;
import com.example.android.speakingnewsapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EMenuAdapter EMenuAdapter;
    RecyclerView recyclerView;
    List<ModelForNews> bufferedNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.newRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        createSampleData();
        EMenuAdapter = new EMenuAdapter(this, bufferedNews);
        EMenuAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(EMenuAdapter);


    }

    private void createSampleData() {

        Log.d("MainActivit","inside sample data ");
        bufferedNews = new ArrayList<ModelForNews>();
        ModelForNews news = new ModelForNews("Beverages", R.drawable.background1);
        bufferedNews.add(news);

        news = new ModelForNews("Meal", R.drawable.backgound2);
        bufferedNews.add(news);

        news = new ModelForNews("Dessert", R.drawable.background3);
        bufferedNews.add(news);




    }
}
