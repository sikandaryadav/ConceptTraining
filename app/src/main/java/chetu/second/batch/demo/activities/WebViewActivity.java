package chetu.second.batch.demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityWebViewBinding;

public class WebViewActivity extends BaseActivity {
    private ActivityWebViewBinding binding;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(context);
        dialog.setTitle(R.string.app_name);
        dialog.setMessage("Loading... Please Wait");
        dialog.setCancelable(false);
        dialog.show();
        binding.webView.loadUrl("https://developer.android.com/reference/android/webkit/WebView");
        binding.webView.setWebViewClient(new MyWebViewClient());

    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
//            binding.progressBar.setVisibility(View.GONE);
            dialog.hide();
        }
    }
}