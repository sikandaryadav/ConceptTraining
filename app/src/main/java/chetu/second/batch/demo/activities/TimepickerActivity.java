package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityTimepickerBinding;

public class TimepickerActivity extends BaseActivity {
    private ActivityTimepickerBinding binding;
    private Calendar calendar;
    private int DAYOFMONTH, MONTH, YEAR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimepickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        calendar = Calendar.getInstance();
        DAYOFMONTH = calendar.get(Calendar.DAY_OF_MONTH);
        MONTH = calendar.get(Calendar.MONTH);
        YEAR = calendar.get(Calendar.YEAR);

//        Log.d("DATE:", dayOfMonth+"/"+(month + 1)+"/"+year);
        binding.btnDatepickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d("DATE:", dayOfMonth+"/"+month+"/"+year);
                    }
                }, YEAR, MONTH, DAYOFMONTH);
                datePickerDialog.show();
            }
        });


    }
}