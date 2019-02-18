package week1.bawei.com.ds_week1.presenter;

import week1.bawei.com.ds_week1.MainActivity;
import week1.bawei.com.ds_week1.model.IModel;
import week1.bawei.com.ds_week1.model.Model;

public class Presenter implements IPresenter{
    private  Model model;
    private MainActivity mainActivity;

    public Presenter(MainActivity mainActivity){
        model = new Model();
        this.mainActivity=mainActivity;
    }
    @Override
    public void getModelData(String url) {
        model.getData(url, new IModel.MCallBack() {
            @Override
            public void OnSucess(Object o) {
                mainActivity.getView(o);
            }

            @Override
            public void OnFail(Exception e) {

            }
        });
    }
}
