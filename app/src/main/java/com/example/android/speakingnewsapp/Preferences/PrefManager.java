package com.example.android.speakingnewsapp.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by anamika on 27/8/17.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String SEAT_NUMBER ="SEAT_NO";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getSeatNumber() {
        return pref.getString(SEAT_NUMBER,"");
    }

    public void setSetNumber(String seat) {
        editor.putString(SEAT_NUMBER,seat);
        editor.commit();
        Log.d("myTag",seat);
    }
}
