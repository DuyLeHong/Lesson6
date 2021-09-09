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

    private static final int REQUEST_CODE_TO_ACTIVITY2 = 101;
    public static final String KEY_DATA1 = "KEY_DATA1";
    public static final String KEY_DATA2 = "KEY_DATA2";
    public static final String KEY_DATA3 = "KEY_DATA3";

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

                Intent in = new Intent(getApplicationContext(), Activity2.class);
                in.putExtra(KEY_DATA1, "String value tu Main Activity");
                in.putExtra(KEY_DATA2, 100);
                in.putExtra(KEY_DATA3, new Student("Tran Tuan Long", 25));

                startActivityForResult(in, REQUEST_CODE_TO_ACTIVITY2);
            }
        });

        FragmentManager fmr = getFragmentManager();

        SimpleFragment simpleFm = (SimpleFragment) fmr.findFragmentById(R.id.fragments);
        simpleFm.setupInfo();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_TO_ACTIVITY2) {

            String sData = data.getStringExtra(Activity2.AC2_KEY_DATA1);

            Log.d(MainActivity.class.getName(), sData);

        }
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