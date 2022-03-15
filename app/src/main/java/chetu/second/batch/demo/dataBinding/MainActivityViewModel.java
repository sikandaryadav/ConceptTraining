package chetu.second.batch.demo.dataBinding;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int count = 0;

    public int setCurrentCount(){
        return count;
    }

    public int getUpdatedCount(){
        return ++count;
    }

}
