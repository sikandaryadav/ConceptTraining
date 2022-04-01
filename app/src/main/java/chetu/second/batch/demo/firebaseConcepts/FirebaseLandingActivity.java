package chetu.second.batch.demo.firebaseConcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityFirebaseLandingBinding;
import chetu.second.batch.demo.utilities.Utility;

public class FirebaseLandingActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityFirebaseLandingBinding binding;
    private FirebaseDb firebaseDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirebaseLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseDb = new FirebaseDb();

        binding.btnInsert.setOnClickListener(this);
        binding.btnGetData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insert:
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setFirstName(binding.etFname.getText().toString());
                studentInfo.setLastName(binding.etLname.getText().toString());
                studentInfo.setPhoneNumber(Long.parseLong(binding.etMobileno.getText().toString()));

                firebaseDb.add(studentInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Utility.showLongToast(FirebaseLandingActivity.this, "Successfuly inserted...");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utility.showLongToast(FirebaseLandingActivity.this, e.getMessage());
                    }
                });

                break;

            case R.id.btn_get_data:
                startActivity(new Intent(FirebaseLandingActivity.this, DisplayListActivity.class));
                break;
        }
    }
}