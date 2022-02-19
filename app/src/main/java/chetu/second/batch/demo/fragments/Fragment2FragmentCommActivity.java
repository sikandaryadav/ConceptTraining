package chetu.second.batch.demo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityFragment2FragmentCommBinding;
import chetu.second.batch.demo.interfaces.OnInputListener;

public class Fragment2FragmentCommActivity extends AppCompatActivity  implements OnInputListener {
    private ActivityFragment2FragmentCommBinding binding;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragment2FragmentCommBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new FragmentSender());
        fragmentTransaction.commit();
    }

    @Override
    public void input(String inputString) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input", inputString);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}