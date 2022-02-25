package chetu.second.batch.demo.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.adapter.DatabaseAdapter;
import chetu.second.batch.demo.adapter.MyRecyclerViewAdapter;
import chetu.second.batch.demo.databinding.ActivityProfileRecyclerviewBinding;
import chetu.second.batch.demo.interfaces.OnItemClickListner;
import chetu.second.batch.demo.model.StudentData;
import chetu.second.batch.demo.utilities.Utility;

public class ProfileRecyclerviewActivity extends AppCompatActivity {
    private ActivityProfileRecyclerviewBinding binding;
    private DatabaseAdapter adapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileRecyclerviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new DatabaseAdapter(this);
        adapter.openDatabase();

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
//        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, getAllStudentList());
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, getAllStudentList(), new OnItemClickListner() {
            @Override
            public void onItemClick(List<StudentData> studentData, int position) {
                Utility.showLongToast(ProfileRecyclerviewActivity.this, studentData.get(position).getfName()+" "+studentData.get(position).getlName());
            }
        });
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private List<StudentData> getAllStudentList(){
        List<StudentData> studentDataList = new ArrayList<>();
        cursor = adapter.getAllData();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                StudentData studentData = new StudentData();
                studentData.setRowId(cursor.getString(0));
                studentData.setfName(cursor.getString(1));
                studentData.setlName(cursor.getString(2));
                studentData.setImage(cursor.getString(3));
                studentDataList.add(studentData);
            } while (cursor.moveToNext());
        }
        return studentDataList;
    }
}