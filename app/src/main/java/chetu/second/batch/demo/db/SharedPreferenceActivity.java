package chetu.second.batch.demo.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.security.Key;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivitySharedPreferenceBinding;
import chetu.second.batch.demo.utilities.Keys;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySharedPreferenceBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPreferenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("chetu_training", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.btnSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        editor.putString(Keys.FIRST_NAME, binding.etFname.getText().toString());
        editor.putString(Keys.LAST_NAME, binding.etLname.getText().toString());
        editor.commit();

        String fname = sharedPreferences.getString(Keys.FIRST_NAME, "");
        String lname = sharedPreferences.getString(Keys.LAST_NAME, "");
        binding.tvName.setText(fname+" "+lname);

    }
}