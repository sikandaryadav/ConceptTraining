package chetu.second.batch.demo.dataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.activities.BaseActivity;
import chetu.second.batch.demo.databinding.ActivityMain2Binding;

public class MainActivity extends BaseActivity /*implements View.OnClickListener*/ {
    private ActivityMain2Binding binding;
//    private int count = 0;
    private MainActivityViewModel viewModel;
    private MainActivityViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
//        viewModelFactory = new MainActivityViewModelFactory(101);
        viewModelFactory = new MainActivityViewModelFactory(new MutableLiveData<>(101));
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel.class);
//        binding.tvDisplay.setText(String.valueOf(count));
//        binding.tvDisplay.setText(String.valueOf(viewModel.setCurrentCount()));
//        binding.btnClick.setOnClickListener(this);

        //TODO : ViewBinding with Databinding
        binding.setLifecycleOwner(this);
        binding.setMyViewModel(viewModel);

//        viewModel.count.observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.tvDisplay.setText(String.valueOf(integer));
//            }
//        });
    }

//    @Override
//    public void onClick(View v) {
////        ++count;
////        binding.tvDisplay.setText(String.valueOf(count));
////        binding.tvDisplay.setText(String.valueOf(viewModel.getUpdatedCount()));
//
//        viewModel.getCurrentCount();
//    }
}