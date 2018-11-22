package wenhao.bawie.com.login_regretrofit_rxjava.mvp.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 2018/11/8.
 */

public class HttpUtils {
    public Api api;

    private HttpUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Common.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }
    private static class GetUtilsInstance{
        private static HttpUtils httpUtils = new HttpUtils();
    }

    public static HttpUtils getUtilsInstance(){
        return GetUtilsInstance.httpUtils;
    }
}
