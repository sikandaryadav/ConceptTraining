package chetu.second.batch.demo.dataBinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
//    private int count;
//    public MainActivityViewModel(int count) {
//        this.count = count;
//    }
//
//    public int setCurrentCount(){
//        return count;
//    }
//
//    public int getUpdatedCount(){
//        return ++count;
//    }

    //TODO : LiveData starts
    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public MainActivityViewModel(MutableLiveData<Integer> count) {
        this.count = count;
    }

    public void setCurrentCount(){
        count.postValue(count.getValue());
    }

    public void getCurrentCount(){
        count.postValue(count.getValue() + 1);
    }

}
