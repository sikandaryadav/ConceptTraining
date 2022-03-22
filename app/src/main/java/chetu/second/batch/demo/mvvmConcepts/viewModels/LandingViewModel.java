package chetu.second.batch.demo.mvvmConcepts.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import chetu.second.batch.demo.mvvmConcepts.model.pojo.PostData;
import chetu.second.batch.demo.mvvmConcepts.model.repositories.PostsRepository;
import chetu.second.batch.demo.retrofit.responses.PostsResponse;

public class LandingViewModel extends AndroidViewModel {
    private PostsRepository postsRepository;
    public LandingViewModel(@NonNull Application application) {
        super(application);
        postsRepository = new PostsRepository(application);
    }

    public MutableLiveData<List<PostData>> getPostsData(){
        return postsRepository.getPostsDataInRepo();
    }

    public MutableLiveData<Boolean> isLoading(){
        return postsRepository.getIsLoading();
    }
}
