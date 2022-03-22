package chetu.second.batch.demo.mvvmConcepts.model;

import java.util.List;

import chetu.second.batch.demo.mvvmConcepts.model.pojo.PostData;
import chetu.second.batch.demo.retrofit.responses.PostsResponse;
import chetu.second.batch.demo.retrofit.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("/posts")
    Call<List<PostData>> getPostsData();

    @GET("/users")
    Call<List<UserResponse>> getUsersData(String userName);
}
