package chetu.second.batch.demo.workManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import android.os.Bundle;
import com.google.android.material.textview.MaterialTextView;
import chetu.second.batch.demo.R;

public class WormanagerActivity extends AppCompatActivity {
    MaterialTextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wormanager);
        view = findViewById(R.id.tv_work_status);

        Constraints constraints = new Constraints
                .Builder()
                .setRequiresCharging(true)
//                .setRequiresBatteryNotLow(true)
                .build();

        Data data = new Data.Builder()
                .putInt("_key", 555)
                .build();

        OneTimeWorkRequest request = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();

        WorkManager.getInstance(this).enqueue(request);

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                view.setText(workInfo.getState().name());
            }
        });


    }
}