package chetu.second.batch.demo.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiName {
    @GET("/posts")
    Call<List<PostsResponse>> getPostsData();


}
