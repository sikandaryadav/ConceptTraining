package chetu.second.batch.demo.mvvmConcepts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.ActivityLandingBinding;
import chetu.second.batch.demo.mvvmConcepts.model.adapter.LandingPostDataAdapter;
import chetu.second.batch.demo.mvvmConcepts.model.pojo.PostData;
import chetu.second.batch.demo.mvvmConcepts.viewModels.LandingViewModel;
import chetu.second.batch.demo.retrofit.responses.PostsResponse;

public class LandingActivity extends AppCompatActivity {
    private ActivityLandingBinding binding;
    private LandingViewModel viewModel;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
        viewModel = new ViewModelProvider(this).get(LandingViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading....");

        viewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) progressDialog.show();
                else progressDialog.dismiss();
            }
        });
        viewModel.getPostsData().observe(this, new Observer<List<PostData>>() {
            @Override
            public void onChanged(List<PostData> postsResponses) {
//                Log.d("Data:", postsResponses.get(0).getBody());
                LandingPostDataAdapter adapter = new LandingPostDataAdapter(LandingActivity.this, postsResponses);
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}