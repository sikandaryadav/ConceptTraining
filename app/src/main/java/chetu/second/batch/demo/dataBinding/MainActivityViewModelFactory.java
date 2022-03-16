package chetu.second.batch.demo.dataBinding;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
//   private int count;
//    public MainActivityViewModelFactory(int count){
//        this.count = count;
//    }

    MutableLiveData<Integer> count;

    public MainActivityViewModelFactory(MutableLiveData<Integer> count) {
        this.count = count;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
//        if (aClass.isAssignableFrom(MainActivityViewModel.class)){
//            return (T) new MainActivityViewModel(count);
//        }

                if (aClass.isAssignableFrom(MainActivityViewModel.class)){
            return (T) new MainActivityViewModel(count);
        }
        throw new IllegalArgumentException("Unknown viewmodel class");

    }
}
