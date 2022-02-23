package chetu.second.batch.demo.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Utility {
    public static void showShortToast(Context context, String msg){
        Toast.makeText(context,  msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static String convertBitmaptoBase64(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
}
