package wenhao.bawie.com.login_regretrofit_rxjava.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.login_regretrofit_rxjava.bean.LoginBean;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.model.HttpUtils;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.view.LoginView;

/**
 * Created by HP on 2018/11/8.
 */

public class LoginPresenter implements IPresenter{
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void getLogin(String mobile,String password){
        Observable<LoginBean> toget = HttpUtils.getUtilsInstance().api.toget(mobile, password);
        toget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LoginBean loginRegBean) {
                        loginView.LoginSuccess(loginRegBean);
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
