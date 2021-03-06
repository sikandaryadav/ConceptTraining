package chetu.second.batch.demo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.FragmentFirstBinding;
import chetu.second.batch.demo.interfaces.OnInputListener;
import chetu.second.batch.demo.utilities.Utility;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private OnInputListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.input(binding.tilInput.getEditText().getText().toString());
                }else {
                    Utility.showLongToast(getActivity(), "Something went wrong.");
                }
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