package chetu.second.batch.demo.activities;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.DesignLayoutBinding;
import chetu.second.batch.demo.utilities.Utility;

public class LayoutDesignActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Button btnClick, btnSubmit;
    Context context;
    EditText etFname, etLname;
    TextView tvResult;
    RadioGroup rbGrpup;
    private String gender = "", cbItemsText = "";
    CheckBox cbItem1, cbItem2, cbItem3, cbItem4;
    private DesignLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO : initialisation of view binding

        binding = DesignLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.design_layout);
        context = this;
        //TODO : Intiliosation of views
//        btnClick = findViewById(R.id.btn_click);
//        btnSubmit = findViewById(R.id.btn_submit);
//        etFname = findViewById(R.id.et_fname);
//        etLname = findViewById(R.id.et_lname);
//        tvResult = findViewById(R.id.tv_result);
//        rbGrpup = findViewById(R.id.rb_group);



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
//        btnClick.setOnClickListener(this);
//        btnSubmit.setOnClickListener(this);
//
//        rbGrpup.setOnCheckedChangeListener(this);


        binding.btnSubmit.setOnClickListener(this);
        binding.btnClick.setOnClickListener(this);

        binding.cbItem1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(context,  binding.cbItem1.getText().toString(), Toast.LENGTH_SHORT).show();
                cbItemsText = binding.cbItem1.getText().toString();
            }
        });

        registerForContextMenu(binding.btnClick);

    }

    @Override
    public void onClick(View v) {
//        int id = v.getId();
//        switch (v.getId()){
//            case R.id.btn_click:
//                //TODO : Gettin gthe value from editext
//                String fName = etFname.getText().toString();
//                String lName = etLname.getText().toString();
//
//                Toast.makeText(context, fName+" "+lName, Toast.LENGTH_SHORT).show();
//
//                //TODO : setting the value in textview
//                tvResult.setText(fName+" "+lName);
//                break;
//
//            case R.id.btn_submit:
////                Toast.makeText(context, "Hello Submit button", Toast.LENGTH_SHORT).show();
//                if (TextUtils.isEmpty(gender)) {
//                    Toast.makeText(context, "Please select gender.", Toast.LENGTH_SHORT).show();
//                    return;
//                   }else {
//                    Toast.makeText(context, gender, Toast.LENGTH_SHORT).show();
//                }
//
//                break;
//        }

        switch (v.getId()){
            case R.id.btn_click:

                    break;

            case R.id.btn_submit:
                if (TextUtils.isEmpty(cbItemsText)){
//                    Toast.makeText(context, "Select atleast one item.", Toast.LENGTH_SHORT).show();
//                    Utility.showShortToast(context, "Select atleast one item.");
                    showShortToast("Select atleast one item.");
                }else {
//                    Toast.makeText(context, cbItemsText, Toast.LENGTH_SHORT).show();
//                    Utility.showLongToast(context, cbItemsText);
//                    showLongToast(cbItemsText);
                    showCustomToast(R.drawable.ic_correct, cbItemsText);
                }
                break;

        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        int id = rbGrpup.getCheckedRadioButtonId();
//        RadioButton radioButton = findViewById(id);
//        RadioButton radioButton = findViewById(checkedId);
////        Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
//        gender = radioButton.getText().toString();
    }

    //TODO : Working with options menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // TODO : Click event on options menu item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_2:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_3:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_4:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_5:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO : Working with Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_items, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_2:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_3:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_4:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
            case R.id.item_5:
                showCustomToast(R.drawable.ic_correct, item.getTitle().toString());
                break;
        }
        return super.onContextItemSelected(item);
    }
}
