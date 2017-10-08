package com.example.android.speakingnewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.speakingnewsapp.Preferences.PrefManager;

public class LoginScreen extends AppCompatActivity {
    EditText seatNumber;
    PrefManager prefManager;
    Button confirmButton;
    int maxLength = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        prefManager = new PrefManager(this);
        seatNumber = (EditText) findViewById(R.id.seat_number);
        seatNumber.setFilters(new InputFilter[]{
                        new InputFilter.LengthFilter(maxLength)
                });
        confirmButton = (Button) findViewById(R.id.okButton);


    }


    public void confirmClick(View view) {
        if(seatNumber.getText().toString().length()==5) {
            startActivity(new Intent(this,FeaturesScreen.class));
            prefManager.setSetNumber(seatNumber.getText().toString());
            finish();
        }
        else
        {
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
            seatNumber.setText("");
        }
    }
}
