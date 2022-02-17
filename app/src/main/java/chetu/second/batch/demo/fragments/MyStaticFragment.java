package chetu.second.batch.demo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import chetu.second.batch.demo.R;

public class MyStaticFragment extends Fragment {
    private String TAG = "_tag";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment - onCreate()");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mystatic_my, container, false);
        Log.d(TAG, "Fragment - onCreateView()");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "Fragment - onViewCreated()");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "Fragment - onViewStateRestored()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment - onStart()");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment - onResume()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Fragment - onSaveInstanceState()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment - onPause()");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment - onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "Fragment - onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment - onDestroy()");
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//    }
}
