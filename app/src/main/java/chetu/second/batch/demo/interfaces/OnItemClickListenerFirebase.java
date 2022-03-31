package chetu.second.batch.demo.interfaces;

import java.util.List;

import chetu.second.batch.demo.firebaseConcepts.StudentInfo;

public interface OnItemClickListenerFirebase {
    void onItemClick(int position, List<StudentInfo> studentInfo);
}
