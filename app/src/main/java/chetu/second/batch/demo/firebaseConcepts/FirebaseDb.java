package chetu.second.batch.demo.firebaseConcepts;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;

public class FirebaseDb {
    public DatabaseReference databaseReference;
    public FirebaseDb() {
        databaseReference = FirebaseDatabase.getInstance().getReference(StudentInfo.class.getSimpleName());
    }


    // Insertion
    public Task<Void> add(StudentInfo studentInfo){
        return databaseReference.push().setValue(studentInfo);
    }

    // getting of data
    public Query get(){
        return databaseReference;
    }

    // Delete

    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    //Update

    public Task<Void> update(String key, Map<String, Object> data){
       return databaseReference.child(key).updateChildren(data);
    }


}
