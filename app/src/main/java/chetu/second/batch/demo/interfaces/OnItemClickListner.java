package chetu.second.batch.demo.interfaces;

import java.util.List;

import chetu.second.batch.demo.model.StudentData;

public interface OnItemClickListner {
    void onItemClick(List<StudentData> studentData, int position);
}
