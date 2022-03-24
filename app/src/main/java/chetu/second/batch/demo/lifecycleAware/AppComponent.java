package chetu.second.batch.demo.lifecycleAware;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class AppComponent implements DefaultLifecycleObserver {
    private String TAG = "lifecycle";
    private String activityName;

    public AppComponent(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onCreate(owner);
        Log.d(TAG, "onCreate Invoked for "+activityName);
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);
        Log.d(TAG, "onStart Invoked for "+activityName);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onResume(owner);
        Log.d(TAG, "onResume Invoked for "+activityName);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onPause(owner);
        Log.d(TAG, "onPause Invoked for "+activityName);
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStop(owner);
        Log.d(TAG, "onStop Invoked for "+activityName);
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
        Log.d(TAG, "onDestroy Invoked for "+activityName);
    }

}
