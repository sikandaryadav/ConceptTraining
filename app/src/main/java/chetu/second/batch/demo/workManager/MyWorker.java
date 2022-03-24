package chetu.second.batch.demo.workManager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        for (int i=1; i<=100; i++){
            Log.d("workLog", "I = "+i);
        }
        return Result.success();
    }
}
