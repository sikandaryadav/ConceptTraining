package chetu.second.batch.demo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import chetu.second.batch.demo.databinding.FragmentFirstBinding;
import chetu.second.batch.demo.interfaces.OnInputListener;
import chetu.second.batch.demo.utilities.Utility;

public class FragmentSender extends Fragment {

    private FragmentFirstBinding binding;
    OnInputListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.input(binding.tilInput.getEditText().getText().toString());
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }
}
