package chetu.second.batch.demo.roomDb.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.adapter.CustomListAdapterForRoomListview;
import chetu.second.batch.demo.databinding.ActivityListviewWithRoomDbBinding;
import chetu.second.batch.demo.databinding.DialogUpdateRoomBinding;
import chetu.second.batch.demo.roomDb.dataAccessObject.UserDao;
import chetu.second.batch.demo.roomDb.dataEntity.User;
import chetu.second.batch.demo.roomDb.databaseClaas.AppDatabase;

public class ListviewWithRoomDbActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    private UserDao dao;
    private ActivityListviewWithRoomDbBinding binding;
    private CustomListAdapterForRoomListview adapter;
    private List<User> userList = new ArrayList<>();
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListviewWithRoomDbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.listView);

        dao = AppDatabase.getInstance(ListviewWithRoomDbActivity.this).userDao();
        new GetDatAsyncTask().execute();

        binding.listView.setOnItemLongClickListener(this);


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        int id1 = position;
        user = userList.get(position);
        return false;
    }

    class GetDatAsyncTask extends AsyncTask<Void, Void, List<User>> {
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(ListviewWithRoomDbActivity.this);
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
            dialog.dismiss();
            userList.addAll(users);
            adapter = new CustomListAdapterForRoomListview(userList, ListviewWithRoomDbActivity.this);
            binding.listView.setAdapter(adapter);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.profile_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_delete_record:
                new DeleteAsynTask().execute();
                break;

            case R.id.item_update_record:
                DialogUpdateRoomBinding binding = DialogUpdateRoomBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(this);
                dialog.setContentView(binding.getRoot());
                dialog.setCancelable(false);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                binding.etFname.setText(user.getFirstName());
                binding.etLname.setText(user.getLastName());
                binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new UpdateAsynTask().execute();
                        dialog.dismiss();
                    }
                });
                break;
        }
        return super.onContextItemSelected(item);
    }

    class DeleteAsynTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... strings) {
            String msg = "";
            int i = dao.deleteUser(user);
            if (i>0){
                msg = i+" data deleted;";
            }else {
                msg = "Something went wrong";
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ListviewWithRoomDbActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    class UpdateAsynTask extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... strings) {
            String msg = "";
            int i = dao.updateUser(user);
            if (i>0){
                msg = i+" data updated;";
            }else {
                msg = "Something went wrong";
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ListviewWithRoomDbActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }


}