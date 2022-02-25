package chetu.second.batch.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.interfaces.OnItemClickListner;
import chetu.second.batch.demo.model.StudentData;
import chetu.second.batch.demo.utilities.Utility;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<StudentData> studentDataList;
    private OnItemClickListner listner;

    public MyRecyclerViewAdapter(Context context, List<StudentData> studentDataList) {
        this.context = context;
        this.studentDataList = studentDataList;
    }

    public MyRecyclerViewAdapter(Context context, List<StudentData> studentDataList, OnItemClickListner listner) {
        this.context = context;
        this.studentDataList = studentDataList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_profile_item, parent, false);
//        return new MyViewHolder(view);
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_profile_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        StudentData data = studentDataList.get(position);
        holder.imageView.setImageBitmap(Utility.convertBase64ToBitmap(data.getImage()));
        holder.textView.setText(data.getfName()+" "+data.getlName());
        listner.onItemClick(studentDataList, position);

    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image_view);
            textView = itemView.findViewById(R.id.item_name);
        }
    }
}
