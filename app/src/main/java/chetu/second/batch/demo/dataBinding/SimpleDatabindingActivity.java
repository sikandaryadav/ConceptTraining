package chetu.second.batch.demo.dataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.activities.BaseActivity;
import chetu.second.batch.demo.databinding.ActivitySimpleDatabindingBinding;

public class SimpleDatabindingActivity extends BaseActivity /*implements View.OnClickListener*/ {
    ActivitySimpleDatabindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyViewModel myViewModel =new  ViewModelProvider(this).get(Student.);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_databinding);

//        binding.btnClick.setOnClickListener(this);
//        binding.setStudent(studentData());
    }

//    @Override
//    public void onClick(View v) {
////        showLongToast(binding.etInput.getText().toString());
//        binding.tvDisplay.setText(binding.etFname.getText().toString());
//    }

    private Student studentData(){
        return new Student("Andy", "Rubin");
    }


}