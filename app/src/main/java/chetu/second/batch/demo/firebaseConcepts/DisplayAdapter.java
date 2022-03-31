package chetu.second.batch.demo.firebaseConcepts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.DisplayItemsBinding;
import chetu.second.batch.demo.interfaces.OnItemClickListenerFirebase;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.MyViewHolder> {
    private Context context;
    private List<StudentInfo> studentInfoList = new ArrayList<>();
    private OnItemClickListenerFirebase listenerFirebase;

    public DisplayAdapter(Context context, OnItemClickListenerFirebase listenerFirebase) {
        this.context = context;
        this.listenerFirebase = listenerFirebase;
    }

    public void setStudentInfoList(List<StudentInfo> studentInfoList) {
        this.studentInfoList = studentInfoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DisplayItemsBinding binding = DisplayItemsBinding.inflate(LayoutInflater.from(context),
                parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvFullName.setText(studentInfoList.get(position).getFirstName()+" "+studentInfoList.get(position).getLastName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenerFirebase != null){
                    listenerFirebase.onItemClick(holder.getAdapterPosition(), studentInfoList);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        DisplayItemsBinding binding;
        public MyViewHolder(@NonNull DisplayItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
