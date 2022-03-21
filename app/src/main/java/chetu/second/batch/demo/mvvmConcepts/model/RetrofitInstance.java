package chetu.second.batch.demo.mvvmConcepts.model;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static <S> S getInstance(Class<S> serviceClass){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(serviceClass);
    }
}
