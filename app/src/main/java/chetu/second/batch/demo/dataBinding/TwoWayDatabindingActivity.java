package chetu.second.batch.demo.dataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityTwoWayDatabindingBinding;

public class TwoWayDatabindingActivity extends AppCompatActivity {
    private ActivityTwoWayDatabindingBinding binding;
    private TwoWayViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_databinding);
        viewModel = new ViewModelProvider(this).get(TwoWayViewModel.class);
        binding.setMyViewBinding(viewModel);
        binding.setLifecycleOwner(this);
    }
}