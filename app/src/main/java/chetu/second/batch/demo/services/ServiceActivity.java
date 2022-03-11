package chetu.second.batch.demo.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityServiceBinding;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityServiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStartService.setOnClickListener(this);
        binding.btnStopService.setOnClickListener(this);
        binding.btnJobService.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
            Intent intent = new Intent(this, SimpleServiceExample.class);
            startService(intent);

            break;
            case R.id.btn_stop_service:
                Intent intentStop = new Intent(this, SimpleServiceExample.class);
                stopService(intentStop);
                break;

            case R.id.btn_job_Service:
                Intent intent1 = new Intent(this, JobIntentServiceExamle.class);
                JobIntentServiceExamle.startJobIntentService(this, intent1);
                break;

        }
    }
}