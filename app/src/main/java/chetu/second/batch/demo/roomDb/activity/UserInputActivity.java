package chetu.second.batch.demo.roomDb.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityUserInputBinding;
import chetu.second.batch.demo.roomDb.dataAccessObject.UserDao;
import chetu.second.batch.demo.roomDb.dataEntity.User;
import chetu.second.batch.demo.roomDb.databaseClaas.AppDatabase;
import chetu.second.batch.demo.utilities.Utility;

public class UserInputActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityUserInputBinding binding;
    private UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUserInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dao = AppDatabase.getInstance(UserInputActivity.this).userDao();

        binding.btnInsert.setOnClickListener(this);
        binding.btnGetData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
            User user = new User(binding.etFname.getText().toString(), binding.etLname.getText().toString(),
                    binding.etMobileno.getText().toString());
            new InsertUserAsyncTask().execute(Collections.singletonList(user));

            break;

            case R.id.btn_get_data:
                new GetDatAsyncTask().execute();
                break;
        }

    }


    class InsertUserAsyncTask extends AsyncTask<List<User>, Void, List<Long>>{

        @Override
        protected List<Long> doInBackground(List<User>... lists) {
            List<User> userList = lists[0];
            ArrayList<User> arrayList = new ArrayList<>(userList);
            List<Long> insertedRows = dao.insertData(arrayList.toArray(arrayList.toArray(new User[]{})));
            return insertedRows;
        }

        @Override
        protected void onPostExecute(List<Long> longs) {
            super.onPostExecute(longs);
            Utility.showLongToast(UserInputActivity.this, longs.size()+" data inserted...");
        }
    }

    class GetDatAsyncTask extends AsyncTask<Void, Void, List<User>>{
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(UserInputActivity.this);
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected List<User> doInBackground(Void... voids) {
            List<User> userList = dao.getAllData();
            return userList;
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            Log.d("TAG:", ""+users.size());
        }
    }
}