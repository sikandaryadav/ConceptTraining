package chetu.second.batch.demo.dataBinding;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> fName = new MutableLiveData<>();
    private MutableLiveData<String> lName = new MutableLiveData<>();

    public MyViewModel(){

    }

    private MutableLiveData<Student> mutableLiveData;

    public MutableLiveData<Student> getStudent(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    public void onPress(View view){
        Student student = new Student(fName.getValue(), lName.getValue());
        mutableLiveData.postValue(student);
    }
}
