package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chetu.second.batch.demo.R;

public class BaseActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        context = this;
    }

    public void showShortToast(String msg){
        Toast.makeText(context,  msg, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void showCustomToast(int resourceId, String msg){
        View view = getLayoutInflater().inflate(R.layout.layout_custom_toast, findViewById(R.id.relative_layout));
        TextView textView = view.findViewById(R.id.tv_msg);
        ImageView imageView = view.findViewById(R.id.image_view);
        textView.setText(msg);
        imageView.setImageResource(resourceId);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();

    }


}