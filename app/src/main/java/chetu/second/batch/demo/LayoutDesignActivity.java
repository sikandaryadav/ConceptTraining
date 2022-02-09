package chetu.second.batch.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LayoutDesignActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Button btnClick, btnSubmit;
    Context context;
    EditText etFname, etLname;
    TextView tvResult;
    RadioGroup rbGrpup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_layout);
        context = this;
        //TODO : Intiliosation of views
        btnClick = findViewById(R.id.btn_click);
        btnSubmit = findViewById(R.id.btn_submit);
        etFname = findViewById(R.id.et_fname);
        etLname = findViewById(R.id.et_lname);
        tvResult = findViewById(R.id.tv_result);
        rbGrpup = findViewById(R.id.rb_group);

        // TODO: click event on button annonimousely
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Hello click button", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Hello Submit button", Toast.LENGTH_SHORT).show();
//            }
//        });

        // TODO: click event using imnplment
        btnClick.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        rbGrpup.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (v.getId()){
            case R.id.btn_click:
                //TODO : Gettin gthe value from editext
                String fName = etFname.getText().toString();
                String lName = etLname.getText().toString();

                Toast.makeText(context, fName+" "+lName, Toast.LENGTH_SHORT).show();

                //TODO : setting the value in textview
                tvResult.setText(fName+" "+lName);
                break;

            case R.id.btn_submit:
                Toast.makeText(context, "Hello Submit button", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        int id = rbGrpup.getCheckedRadioButtonId();
//        RadioButton radioButton = findViewById(id);
        RadioButton radioButton = findViewById(checkedId);

        Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

    }
}
