package chetu.second.batch.demo.retrofit;

import java.util.List;

import chetu.second.batch.demo.retrofit.responses.PopularPersonResponse;
import chetu.second.batch.demo.retrofit.responses.PostsResponse;
import chetu.second.batch.demo.retrofit.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {
    @GET("/posts")
    Call<List<PostsResponse>> getPostsData();

    @GET("/users")
    Call<List<UserResponse>> getUsersData(String userName);

    @GET("/3/person/popular")
    Call<PopularPersonResponse> getPopularPersons(@Query("api_key") String apiKey);

}
