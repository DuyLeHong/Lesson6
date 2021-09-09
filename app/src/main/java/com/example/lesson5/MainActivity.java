package com.example.lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityButton = (Button) findViewById(R.id.activity_button);

        // perform setOnClickListener event on Button
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Toast.makeText(getApplicationContext(), "Activity's Button", Toast.LENGTH_LONG).show();
                
                startActivity(new Intent(getApplicationContext(), Activity2.class));
            }
        });

        FragmentManager fmr = getFragmentManager();

        SimpleFragment simpleFm = (SimpleFragment) fmr.findFragmentById(R.id.fragments);
        simpleFm.setupInfo();

    }

    public void doSomeThing() {
        Log.d("AAA", "do something");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //viet code o day
    }

    @Override
    protected void onResume() {
        super.onResume();

        //viet code o day
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}