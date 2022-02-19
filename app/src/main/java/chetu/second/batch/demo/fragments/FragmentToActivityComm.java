package chetu.second.batch.demo.fragments;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityFragmentToCommBinding;
import chetu.second.batch.demo.interfaces.OnInputListener;

public class FragmentToActivityComm extends AppCompatActivity implements OnInputListener {
    private ActivityFragmentToCommBinding binding;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentToCommBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new FirstFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void input(String inputString) {
        binding.tvDisplay.setText(inputString);
    }
}