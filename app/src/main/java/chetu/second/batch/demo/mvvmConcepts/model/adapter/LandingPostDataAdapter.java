package chetu.second.batch.demo.mvvmConcepts.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.LayoutPostDataItemBinding;
import chetu.second.batch.demo.retrofit.responses.PostsResponse;

public class LandingPostDataAdapter extends RecyclerView.Adapter<LandingPostDataAdapter.MyViewholder> {
    private Context context;
    private List<PostsResponse> postsResponseList;

    public LandingPostDataAdapter(Context context, List<PostsResponse> postsResponseList) {
        this.context = context;
        this.postsResponseList = postsResponseList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostDataItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_post_data_item, parent, false);
        return new MyViewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        PostsResponse responseData = postsResponseList.get(position);
        holder.binding.tvTitle.setText(responseData.getTitle());
    }

    @Override
    public int getItemCount() {
        return postsResponseList.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        private LayoutPostDataItemBinding binding;
        public MyViewholder(LayoutPostDataItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
