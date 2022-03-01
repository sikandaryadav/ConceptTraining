package chetu.second.batch.demo.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.utilities.Utility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsDataActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_data);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<UserResponse>> call = apiName.getUsersData("Any Rubin");
        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200){
                    List<UserResponse> userResponseList = response.body();
                    for (UserResponse data : userResponseList){
                        Log.d("USERSDATA:", data.getAddressData().getGeoData().getLatitude());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(PostsDataActivity.this, t.getMessage());
            }
        });
        //TODO : Implementation of POSTS API
//        Call<List<PostsResponse>> call = apiName.getPostsData();
//        call.enqueue(new Callback<List<PostsResponse>>() {
//            @Override
//            public void onResponse(Call<List<PostsResponse>> call, Response<List<PostsResponse>> response) {
//                progressDialog.hide();
//                if (response.isSuccessful() && response.code() == 200){
//                    List<PostsResponse> postsResponses = response.body();
//                    for (PostsResponse postData : postsResponses){
//                        Log.d("DATA:", postData.getUserId()+"\n"+postData.getId()+"\n"+postData.getTitle()+"\n"+postData.getBody());
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<PostsResponse>> call, Throwable t) {
//                progressDialog.hide();
//                Utility.showLongToast(PostsDataActivity.this, t.getMessage());
//            }
//        });





    }


}