package com.ftn.webshop.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ftn.webshop.R;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class DayNightSwitch extends AppCompatActivity {

    //Theme
    com.mahfa.dnswitch.DayNightSwitch dayNightSwitch;
    View background_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_night_switch);

        dayNightSwitch = findViewById(R.id.dayNight);
        background_view = findViewById(R.id.backgroundView);

        dayNightSwitch.setDuration(450);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                if(isNight){
                    Toast.makeText(getApplicationContext(), "Night mode selected!", Toast.LENGTH_LONG).show();
                    background_view.setAlpha(1f);
                    //finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Day mode selected!", Toast.LENGTH_LONG).show();
                    background_view.setAlpha(0f);
                    //finish();
                }
            }
        });
    }

}
