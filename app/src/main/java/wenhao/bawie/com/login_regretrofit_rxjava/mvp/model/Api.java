package wenhao.bawie.com.login_regretrofit_rxjava.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.login_regretrofit_rxjava.bean.LoginBean;
import wenhao.bawie.com.login_regretrofit_rxjava.bean.RegBean;

/**
 * Created by HP on 2018/11/8.
 */

public interface Api {
    @GET("user/login")
    Observable<LoginBean> toget(@Query("mobile") String mobile, @Query("password") String password);
    @GET("user/reg")
    Observable<RegBean> toget1(@Query("mobile") String mobile, @Query("password") String password);
}
