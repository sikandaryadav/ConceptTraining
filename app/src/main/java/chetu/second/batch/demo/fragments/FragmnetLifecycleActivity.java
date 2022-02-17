package chetu.second.batch.demo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import chetu.second.batch.demo.R;

public class FragmnetLifecycleActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "_tag";
    private FragmentManager fragmentManager;
    private Button btnAdd, btnRemove, btnReplace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmnet_lifecycle);
        Log.d(TAG, "Activity - onCreate()");

        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);
        btnReplace = findViewById(R.id.btn_replace);

        btnAdd.setOnClickListener(this);
        btnReplace.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity - onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity - onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity - onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, new MyStaticFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.btn_replace:
                FragmentTransaction fragmentTransactionRepalce= fragmentManager.beginTransaction();
                fragmentTransactionRepalce.replace(R.id.fragment_container, new FragmnetB());
                fragmentTransactionRepalce.addToBackStack(null);
                fragmentTransactionRepalce.commit();
                break;
            case R.id.btn_remove:
                for (Fragment fragment : fragmentManager.getFragments()){
                    FragmentTransaction fragmentTransactionRemove = fragmentManager.beginTransaction();
                    fragmentTransactionRemove.remove(fragment);
                    fragmentTransactionRemove.addToBackStack(null);
                    fragmentTransactionRemove.commit();
                }
                break;
        }
    }
}