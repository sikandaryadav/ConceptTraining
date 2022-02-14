package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityIntent1Binding;
import chetu.second.batch.demo.databinding.ActivityIntent2Binding;

public class IntentActivity1 extends BaseActivity implements View.OnClickListener {
    private ActivityIntent1Binding binding;
    private String TAG = "Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntent1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(this);
        Log.d(TAG, "onCreate() - 1");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, IntentActivity2.class);
        // Putting the data to the intent object
        intent.putExtra("fname", binding.etFname.getText().toString());
        intent.putExtra("lname", binding.etLname.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() - 1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() - 1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() - 1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() - 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() - 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() - 1");
    }
}