package chetu.second.batch.demo.dataBinding;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if (aClass.isAssignableFrom(MainActivityViewModel.class)){
            return (T) new MainActivityViewModel();
        }

        throw new IllegalArgumentException("Unknown viewmodel class");

    }
}
