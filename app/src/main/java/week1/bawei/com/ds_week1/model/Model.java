package week1.bawei.com.ds_week1.model;

import week1.bawei.com.ds_week1.bean.NewsBean;
import week1.bawei.com.ds_week1.https.OkHttp;

public class Model implements IModel{

    @Override
    public void getData(String url, final MCallBack mCallBack) {
        OkHttp.getOk().getRequest(url, NewsBean.class, new OkHttp.NewCallBack() {
            @Override
            public void Sucess(Object o) {
                mCallBack.OnSucess(o);
            }

            @Override
            public void Fail(Exception e) {

            }
        });
    }
}
