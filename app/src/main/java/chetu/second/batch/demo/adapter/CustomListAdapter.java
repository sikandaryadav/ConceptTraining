package chetu.second.batch.demo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chetu.second.batch.demo.R;
import chetu.second.batch.demo.databinding.CustomProfileItemBinding;
import chetu.second.batch.demo.model.StudentData;
import chetu.second.batch.demo.utilities.Utility;

public class CustomListAdapter extends BaseAdapter {
    private List<StudentData> list;
    private Context context;
    public CustomListAdapter(List<StudentData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_profile_item, parent, false);
        ImageView imageView = convertView.findViewById(R.id.item_image_view);
        TextView tvName = convertView.findViewById(R.id.item_name);
        StudentData data = list.get(position);

        Bitmap bitmap = Utility.convertBase64ToBitmap(data.getImage());
        imageView.setImageBitmap(bitmap);
        tvName.setText(data.getfName()+" "+data.getlName());

        return convertView;
    }
}
