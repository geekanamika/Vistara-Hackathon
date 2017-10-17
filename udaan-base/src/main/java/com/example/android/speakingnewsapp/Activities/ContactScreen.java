package com.example.android.speakingnewsapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.android.speakingnewsapp.AppConfig;
import com.example.android.speakingnewsapp.AppController;
import com.example.android.speakingnewsapp.Preferences.PrefManager;
import com.example.android.speakingnewsapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ContactScreen extends AppCompatActivity {

    public static final String TAG="tag";
    at.markushi.ui.CircleButton tea_circle;
    at.markushi.ui.CircleButton coffee_circle;
    at.markushi.ui.CircleButton blanket_circle;
    at.markushi.ui.CircleButton water_circle;
    EditText msg;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tea_circle= (at.markushi.ui.CircleButton) findViewById(R.id.tea_circle);
        coffee_circle= (at.markushi.ui.CircleButton) findViewById(R.id.coffee_circle);
        blanket_circle= (at.markushi.ui.CircleButton) findViewById(R.id.blanket_circle);
        water_circle= (at.markushi.ui.CircleButton) findViewById(R.id.water_circle);
        Glide.with(this).load(R.drawable.tea0).into(tea_circle);
        Glide.with(this).load(R.drawable.coffee0).into(coffee_circle);
        Glide.with(this).load(R.drawable.blacket0).into(blanket_circle);
        Glide.with(this).load(R.drawable.water0).into(water_circle);
        msg=(EditText)findViewById(R.id.message);
        btnSend=(Button)findViewById(R.id.send);

        tea_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.append("Tea"+"\n");
            }
        });
        coffee_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.append("Coffee"+"\n");
            }
        });
        water_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.append("Water"+"\n");
            }
        });

        blanket_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.append("Blanket"+"\n");
            }
        });

        if(btnSend==null)
            Log.d(TAG, "NULLLL");

        else {

            Log.d(TAG, "NOT NULLLL");
            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String message = msg.getText().toString();
                    msg.setText("");
                    Log.d(TAG, message);
                    PrefManager prefManager;
                    prefManager = new PrefManager(ContactScreen.this);
                    String seatNumber = prefManager.getSeatNumber();
                    Log.d("ContactScreen",seatNumber);
                    sendRequest(seatNumber, message);
                }
            });
        }
    }

    private void sendRequest(final String seat_no, final String request_made) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());

                try {

                    Log.d("check","check1");
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    Log.d("check","check2");
                    // Check for error node in json
                    if (!error) {
                        Toast.makeText(ContactScreen.this, "Request Sent Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("seat_no", seat_no);
                params.put("request_made", request_made);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
