package chetu.second.batch.demo.firebaseConcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityDisplayBinding;
import chetu.second.batch.demo.interfaces.OnItemClickListenerFirebase;
import chetu.second.batch.demo.utilities.Utility;

public class DisplayListActivity extends AppCompatActivity {
    private ActivityDisplayBinding binding;
    private FirebaseDb firebaseDb;
    private List<StudentInfo> studentInfoList = new ArrayList<>();
    DisplayAdapter displayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseDb = new FirebaseDb();
        displayAdapter = new DisplayAdapter(this, new OnItemClickListenerFirebase() {
            @Override
            public void onItemClick(int position, List<StudentInfo> studentInfo) {
//                Utility.showLongToast(DisplayActivity.this, studentInfo.get(position).getFirstName());
                Intent intent = new Intent(DisplayListActivity.this, DisplayInfoActivity.class);
                intent.putExtra("_student_info_", new Gson().toJson(studentInfo.get(position)));
                startActivity(intent);
            }
        });
        binding.revView.setLayoutManager(new LinearLayoutManager(this));
        binding.revView.setAdapter(displayAdapter);

        firebaseDb.get().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    StudentInfo studentInfo = dataSnapshot.getValue(StudentInfo.class);
                    studentInfo.setKey(dataSnapshot.getKey());
                    studentInfoList.add(studentInfo);
                    displayAdapter.setStudentInfoList(studentInfoList);
                    displayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (studentInfoList.size() > 0) studentInfoList.clear();
        firebaseDb.get().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    StudentInfo studentInfo = dataSnapshot.getValue(StudentInfo.class);
                    studentInfo.setKey(dataSnapshot.getKey());
                    studentInfoList.add(studentInfo);
                    displayAdapter.setStudentInfoList(studentInfoList);
                    displayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}