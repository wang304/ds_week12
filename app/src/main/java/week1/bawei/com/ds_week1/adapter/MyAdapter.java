package week1.bawei.com.ds_week1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import week1.bawei.com.ds_week1.MainActivity;
import week1.bawei.com.ds_week1.R;
import week1.bawei.com.ds_week1.bean.NewsBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private NewsBean newsBean;
    private List<NewsBean.DataBeanX> list;
    public MyAdapter(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.text_view.setText(list.get(1).getData().get(i).getTitle());
        /*Glide.with(context).load(list.get(1).getData().get(i).getPics()).into(myViewHolder.img_view);*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView text_view;
        /*private final ImageView img_view;*/

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_view = itemView.findViewById(R.id.text_view);
            /*img_view = itemView.findViewById(R.id.img_view);*/
        }
    }
}
