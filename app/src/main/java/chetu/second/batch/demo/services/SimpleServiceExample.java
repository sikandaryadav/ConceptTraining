package chetu.second.batch.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class SimpleServiceExample extends Service {
    private String TAG = "Service:";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // ctrl + o

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service:", "Service created.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service:", "Service started");
        for(int i=0; i<=100 ; i++){
            Log.d("Service:", ""+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Service:", Thread.currentThread().getName());
//        stopSelf();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service:", "Service stopped");
    }
}
