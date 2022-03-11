package chetu.second.batch.demo.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class JobIntentServiceExamle extends JobIntentService {
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d("Service:", "Service started");
        for(int i=0; i<=10 ; i++){
            Log.d("Service:", ""+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Service:", Thread.currentThread().getName());
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service:", "Service stopped");
    }

    public static void startJobIntentService(Context context, Intent intent){
        enqueueWork(context, JobIntentServiceExamle.class, 10, intent);
    }
}
