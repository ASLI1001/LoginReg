package wenhao.bawie.com.login_regretrofit_rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wenhao.bawie.com.login_regretrofit_rxjava.bean.LoginBean;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.presenter.LoginPresenter;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.presenter.RegPresenter;
import wenhao.bawie.com.login_regretrofit_rxjava.mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private EditText edit_name;
    private EditText edit_password;
    private Button but_login;
    private LoginPresenter loginPresenter;
    private String moblie;
    private String password;
    private Button but_reg;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        onClick();
    }

    private void onClick() {
        but_login.setOnClickListener(this);
        but_reg.setOnClickListener(this);
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_password = (EditText) findViewById(R.id.edit_password);
        but_reg = (Button) findViewById(R.id.but_reg);
        but_login = (Button) findViewById(R.id.but_login);
        loginPresenter = new LoginPresenter(this);
        regPresenter = new RegPresenter(this);
    }

    @Override
    public void onClick(View v) {
        moblie = edit_name.getText().toString();
        password = edit_password.getText().toString();
        switch (v.getId()){
            case R.id.but_login:
                loginPresenter.getLogin(moblie,password);
                break;
            case R.id.but_reg:
                regPresenter.getReg(moblie,password);
                break;
        }
    }

    //注册成功
    @Override
    public void regSuccess(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
    //登录成功
    @Override
    public void LoginSuccess(LoginBean loginRegBean) {
        String code = loginRegBean.getCode();
        String msg = loginRegBean.getMsg();
        if (code.equals("1")){
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
