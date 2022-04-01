package chetu.second.batch.demo.firebaseConcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityDisplayInfoBinding;
import chetu.second.batch.demo.databinding.LayoutUpdateInfoBinding;
import chetu.second.batch.demo.utilities.Utility;

public class DisplayInfoActivity extends AppCompatActivity {
    private ActivityDisplayInfoBinding binding;
    private FirebaseDb firebaseDb;
    private StudentInfo studentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseDb  = new FirebaseDb();
        String studentString = getIntent().getStringExtra("_student_info_");
        studentInfo = new Gson().fromJson(studentString, StudentInfo.class);

        binding.tvResult.setText(studentInfo.getFirstName()+" "+studentInfo.getLastName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_update_record:
                // TODO : Update
//                LayoutUpdateInfoBinding binding1 =
//                        LayoutUpdateInfoBinding.inflate(getLayoutInflater());
//                Dialog dialog = new Dialog(DisplayInfoActivity.this);
//                dialog.setContentView(binding1.getRoot());
//                binding1.etFname.setText(studentInfo.getFirstName());
//                binding1.etLname.setText(studentInfo.getLastName());
//                binding1.etMobileno.setText(String.valueOf(studentInfo.getPhoneNumber()));

                Dialog dialog = new Dialog(DisplayInfoActivity.this);
                dialog.setContentView(R.layout.layout_update_info);
                EditText etFname = dialog.findViewById(R.id.et_fname);
                EditText etLname = dialog.findViewById(R.id.et_lname);
                EditText etMob = dialog.findViewById(R.id.et_mobileno);
                Button btnUpdate = dialog.findViewById(R.id.btn_update);



                etFname.setText(studentInfo.getFirstName());
                etLname.setText(studentInfo.getLastName());
                etMob.setText(String.valueOf(studentInfo.getPhoneNumber()));




                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("firstName", etFname.getText().toString());
                        hashMap.put("lastName", etLname.getText().toString());
                        hashMap.put("phoneNumber", Long.parseLong(etMob.getText().toString()));

                        firebaseDb.update(studentInfo.getKey(), hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Utility.showLongToast(DisplayInfoActivity.this, "Updated....");
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Utility.showLongToast(DisplayInfoActivity.this, e.getMessage());
                            }
                        });
                    }
                });

                dialog.show();


                break;
            case R.id.item_delete_record:
                //TODO : Delete
                firebaseDb.remove(studentInfo.getKey()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utility.showLongToast(DisplayInfoActivity.this, e.getMessage());
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}