package chetu.second.batch.demo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.FragmentDisplayBinding;

public class DisplayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDisplayBinding binding = FragmentDisplayBinding.inflate(getLayoutInflater());
        Bundle bundle = getArguments();
        binding.tvDisplay.setText(bundle.getString("input"));
        return binding.getRoot();
    }
}