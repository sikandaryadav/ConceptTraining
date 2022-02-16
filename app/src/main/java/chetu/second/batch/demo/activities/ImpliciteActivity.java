package chetu.second.batch.demo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityImpliciteBinding;

public class ImpliciteActivity extends BaseActivity implements View.OnClickListener {
    private ActivityImpliciteBinding binding;
    private String[] PERMISSIONS = new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImpliciteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnView.setOnClickListener(this);
        binding.btnDial.setOnClickListener(this);
        binding.btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/reference/android/content/Intent"));
                startActivity(intent);
                break;
            case R.id.btn_dial:
                Intent intentDial = new Intent(Intent.ACTION_DIAL);
                intentDial.setData(Uri.parse("tel:9625033237"));
                startActivity(intentDial);
                break;
            case R.id.btn_call:
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    doCall();

                }else {
                    ActivityCompat.requestPermissions(ImpliciteActivity.this, PERMISSIONS, 1);
                }
                break;
        }
    }

    private void doCall() {
        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9625033237"));
        startActivity(intentCall);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // TODO: DO UR JOB
                doCall();

            }else {
                showLongToast("Permission Denied!");
            }
        }
    }
}