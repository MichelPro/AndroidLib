package com.michel.sample.mvp.ui.login;

import com.michel.intrastructure.mvp.BasePresenter;

/**
 * 如果不需要任何自定义过程，直接继承Lib中的MVP-Base的写法
 * Created by Michel on 2018/3/27.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private final LoginModel model;

    public LoginPresenter() {
        model = new LoginModel(this);
    }

    @Override
    public void login(String userName, String password) {
        model.login(userName, password);
    }

    @Override
    public void loginSuccess() {
        getView().loginSuccess();
    }

    @Override
    public void loginFailure() {
        getView().loginFailure();
    }
}
