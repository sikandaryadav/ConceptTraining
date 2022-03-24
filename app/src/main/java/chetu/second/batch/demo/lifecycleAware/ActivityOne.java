package chetu.second.batch.demo.lifecycleAware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import chetu.second.batch.demo.R;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        getLifecycle().addObserver(new AppComponent("ActivityOne"));
    }
}