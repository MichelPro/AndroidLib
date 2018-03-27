package com.michel.sample.mvp.ui.login;

import com.michel.intrastructure.mvp.BaseModel;

/**
 * 如果不需要任何自定义过程，直接继承Lib中的MVP-Base的写法
 * Created by Michel on 2018/3/27.
 */

public class LoginModel extends BaseModel implements LoginContract.Model{


    private final LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(String userName, String password) {
        // 超时就不模拟了
        // login
        switch (userName) {
            case "Success":
                // loginSuccess
                presenter.loginSuccess();
                break;
            case "Failure":
                // loginFailure
                presenter.loginFailure();
                break;
        }
    }
}
