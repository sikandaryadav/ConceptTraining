package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.model.UserData;
import chetu.second.batch.demo.model.UserDataParceble;
import chetu.second.batch.demo.model.UserDataWithSerilKeys;
import chetu.second.batch.demo.utilities.Keys;

public class IntentActivity2 extends AppCompatActivity {
    private String TAG = "Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        Log.d(TAG, "onCreate() - 2");

        Intent intent = getIntent();
        // TODO : Getting data directly from intent
//        String fname = intent.getStringExtra(Keys.FIRST_NAME);
//        String lname = intent.getStringExtra(Keys.LAST_NAME);

        // TODO : Getting data directly from Bundle
//        Bundle bundle = intent.getExtras();
//        String fname = bundle.getString(Keys.FIRST_NAME);
//        String lname = bundle.getString(Keys.LAST_NAME);

        //TODO : Getting Serialized Data from Intent
//        UserData userData = (UserData) intent.getSerializableExtra(Keys.SERIALIZED_DATA);
//        Log.d("DATA", fname+" "+lname);

        //TODO : Getting JSON Data from Intent
//        String jsonString = intent.getStringExtra(Keys.JSON_DATA);
//        UserDataWithSerilKeys data =  new Gson().fromJson(jsonString, UserDataWithSerilKeys.class);

        //TODO : Getting Parceble Data from Intent
        UserDataParceble data = intent.getParcelableExtra(Keys.PARCEBLE_DATA);
        Log.d("DATA", data.getfName()+" "+data.getlName());
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