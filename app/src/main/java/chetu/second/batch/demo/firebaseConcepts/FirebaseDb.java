package chetu.second.batch.demo.firebaseConcepts;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDb {
    public DatabaseReference databaseReference;
    public FirebaseDb() {
        databaseReference = FirebaseDatabase.getInstance().getReference(StudentInfo.class.getSimpleName());
    }

    public Task<Void> add(StudentInfo studentInfo){
        return databaseReference.push().setValue(studentInfo);
    }
}
