package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import chetu.second.batch.demo.R;

public class IntentActivity2 extends AppCompatActivity {
    private String TAG = "Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        Log.d(TAG, "onCreate() - 2");

        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");

        Log.d("DATA", fname+" "+lname);
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() - 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() - 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() - 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() - 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() -2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() - 2");
    }
}