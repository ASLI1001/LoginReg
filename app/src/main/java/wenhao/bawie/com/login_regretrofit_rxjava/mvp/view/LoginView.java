package wenhao.bawie.com.login_regretrofit_rxjava.mvp.view;

import wenhao.bawie.com.login_regretrofit_rxjava.bean.LoginBean;

/**
 * Created by HP on 2018/11/8.
 */

public interface LoginView {
    void regSuccess(String msg);
    void LoginSuccess(LoginBean loginRegBean);
}
