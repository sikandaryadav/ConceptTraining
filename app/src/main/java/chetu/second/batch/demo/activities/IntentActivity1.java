package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityIntent1Binding;
import chetu.second.batch.demo.databinding.ActivityIntent2Binding;
import chetu.second.batch.demo.model.UserData;
import chetu.second.batch.demo.model.UserDataParceble;
import chetu.second.batch.demo.model.UserDataWithSerilKeys;
import chetu.second.batch.demo.utilities.Keys;

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
        // TODO : Putting the data to the intent object
//        intent.putExtra(Keys.FIRST_NAME, binding.etFname.getText().toString());
//        intent.putExtra(Keys.LAST_NAME, binding.etLname.getText().toString());
//        startActivity(intent);

        // TODO : Sending data through bundle

//        Bundle bundle = new Bundle();
//        bundle.putString(Keys.FIRST_NAME, binding.etFname.getText().toString());
//        bundle.putString(Keys.LAST_NAME, binding.etLname.getText().toString());
//        intent.putExtras(bundle);
//        startActivity(intent);

        // TODO : Sending Serialized Data
//        UserData userData = new UserData();
//        userData.setfName(binding.etFname.getText().toString());
//        userData.setlName(binding.etLname.getText().toString());
//        intent.putExtra(Keys.SERIALIZED_DATA, userData);
//        startActivity(intent);

        // TODO : Passing data into json format

//        UserDataWithSerilKeys data = new UserDataWithSerilKeys();
//        data.setFirstName(binding.etFname.getText().toString());
//        data.setLastName(binding.etLname.getText().toString());
//        intent.putExtra(Keys.JSON_DATA, new Gson().toJson(data));
//        startActivity(intent);

        //TODO : Passing Parceble Data;
        UserDataParceble dataParceble = new UserDataParceble(binding.etFname.getText().toString(), binding.etLname.getText().toString());
        intent.putExtra(Keys.PARCEBLE_DATA, dataParceble);
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