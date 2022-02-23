package chetu.second.batch.demo.db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.activities.BaseActivity;
import chetu.second.batch.demo.activities.ImpliciteActivity;
import chetu.second.batch.demo.adapter.DatabaseAdapter;
import chetu.second.batch.demo.databinding.ActivityProfileListBinding;
import chetu.second.batch.demo.databinding.LayoutProfileBinding;
import chetu.second.batch.demo.utilities.Utility;

public class ProfileListActivity extends BaseActivity {
    private ActivityProfileListBinding binding;
    LayoutProfileBinding profileBinding;
    private DatabaseAdapter adapter;
    private String imageInBase64;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new DatabaseAdapter(this);
        adapter.openDatabase();

        cursor = adapter.getAllData();
        Log.d("DATA", ""+cursor);
        cursor.moveToFirst();
        do {
            String rowId = cursor.getString(0);
            String fName = cursor.getString(1);
            String lName = cursor.getString(2);
            String image = cursor.getString(3);

            Log.d("DATA1", rowId+" "+fName+" "+lName+" "+image);
        }while (cursor.moveToNext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_create_profile:
                profileBinding = LayoutProfileBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(this);
                dialog.setContentView(profileBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                profileBinding.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ContextCompat.checkSelfPermission(ProfileListActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                            callCamera();
                        }else {
                            ActivityCompat.requestPermissions(ProfileListActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        }
                    }
                });

                profileBinding.btnCreateProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      adapter.insertData(ProfileListActivity.this, profileBinding.etFirstName.getText().toString(), profileBinding.etLastName.getText().toString(), imageInBase64);
                      dialog.dismiss();
                    }
                });

                break;
            case R.id.item_delete_all_profile:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void callCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // TODO: DO UR JOB
                callCamera();
            } else {
                showLongToast("Permission Denied!");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageInBase64 = Utility.convertBitmaptoBase64(bitmap);
            profileBinding.imageView.setImageBitmap(bitmap);

        }
    }
}