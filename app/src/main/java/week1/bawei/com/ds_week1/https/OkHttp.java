package week1.bawei.com.ds_week1.https;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp {
    private static volatile OkHttp instance;
    //拦截器
    private static Interceptor getInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i("aaa", "intercept: 拦截前");
                Response proceed = chain.proceed(request);
                Log.i("bbb", "intercept: 拦截后");
                return proceed;
            }
        };;
        return interceptor;
    }
    //单例
    public static OkHttp getOk(){
        if (instance==null){
            synchronized (OkHttp.class){
                instance = new OkHttp();
            }
        }
        return instance;
    }
    //接口
    public interface NewCallBack{
        void Sucess(Object o);
        void Fail(Exception e);
    }
    private Handler handler=new Handler();
    public void getRequest(String url, final Class clas, final NewCallBack newCallBack){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                newCallBack.Fail(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(string, clas);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        newCallBack.Sucess(o);
                    }
                });
            }
        });
    }
}
