package week1.bawei.com.ds_week1.model;

public interface IModel {
    public void getData(String url, MCallBack mCallBack);
    public interface MCallBack{
        void OnSucess(Object o);
        void OnFail(Exception e);
    }
}
