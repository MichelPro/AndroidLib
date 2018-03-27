package com.michel.sample.mvp.ui.login;

import android.os.Bundle;

import com.michel.intrastructure.mvp.BaseActivity;
import com.michel.intrastructure.mvp.CreatePresenter;
import com.michel.sample.R;

/**
 * 如果不需要任何自定义过程，直接继承Lib中的MVP-Base的写法
 */
@CreatePresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 点击事件
        getPresenter().login("userName", "pwd");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure() {

    }
}
