package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityDialogsBinding;
import chetu.second.batch.demo.databinding.CustomDialogBinding;

public class DialogsActivity extends BaseActivity implements View.OnClickListener {
    private ActivityDialogsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlertDialog.setOnClickListener(this);
        binding.btnCustomDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert_dialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.drawable.ic_alert);
                builder.setCancelable(false);
                builder.setMessage("Do you want to exit?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

//                builder.show();

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setAllCaps(false);
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.teal_200));
                break;

            case R.id.btn_custom_dialog:
                // CUsotm dialog



                CustomDialogBinding customBinding = CustomDialogBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(context);
                dialog.setContentView(customBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                customBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showLongToast(customBinding.etFname.getText().toString());
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}