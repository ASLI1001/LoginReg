package wenhao.bawie.com.login_regretrofit_rxjava.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.login_regretrofit_rxjava.bean.RegBean;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.model.HttpUtils;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.view.LoginView;

/**
 * Created by HP on 2018/11/8.
 */

public class RegPresenter implements IPresenter{
    private LoginView loginView;

    public RegPresenter(LoginView loginView) {
        this.loginView = loginView;
    }
    public void getReg(String mobile,String password){
        Observable<RegBean> toget1 = HttpUtils.getUtilsInstance().api.toget1(mobile, password);
        toget1.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RegBean regLogin) {
                        loginView.regSuccess(regLogin.getMsg());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        if (loginView!=null){
            loginView=null;
        }
    }
}
