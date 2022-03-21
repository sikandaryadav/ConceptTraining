package chetu.second.batch.demo.dataBinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TwoWayViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();

    public TwoWayViewModel() {
        name = new MutableLiveData<String>("DataBinding");
    }
}
