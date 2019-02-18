package week1.bawei.com.ds_week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import week1.bawei.com.ds_week1.adapter.MyAdapter;
import week1.bawei.com.ds_week1.bean.NewsBean;
import week1.bawei.com.ds_week1.presenter.Presenter;
import week1.bawei.com.ds_week1.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    private Presenter presenter;
    private RecyclerView recy_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_view = findViewById(R.id.recy_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,OrientationHelper.VERTICAL,false);
        recy_view.setLayoutManager(linearLayoutManager);
        presenter = new Presenter(this);
        presenter.getModelData("http://365jia.cn/news/api3/365jia/news/headline?page=1");
    }

    @Override
    public void getView(Object o) {
        NewsBean bean= (NewsBean) o;
        MyAdapter adapter=new MyAdapter(this,bean);
        Log.i("dt", "getView: "+bean.getHttpStatusCode());
        Log.i("dt", "getView: "+bean.getHttpStatusCode());
    }
}
