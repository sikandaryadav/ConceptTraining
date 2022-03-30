package chetu.second.batch.demo.firebaseConcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityFirebaseLandingBinding;
import chetu.second.batch.demo.utilities.Utility;

public class FirebaseLandingActivity extends AppCompatActivity {
    private ActivityFirebaseLandingBinding binding;
    private FirebaseDb firebaseDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirebaseLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseDb = new FirebaseDb();
        binding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

            }
        });
    }
}