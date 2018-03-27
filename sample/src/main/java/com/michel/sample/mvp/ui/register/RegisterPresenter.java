package com.michel.sample.mvp.ui.register;

import com.michel.sample.mvp.base.MyBasePresenter;

/**
 * 如果需要通过P层去做M和V的交互通道，都存在共有方法requestError，
 * 自定义一个MyBasePresenter，在其中获取View去调用相关方法
 * Created by Michel on 2018/3/27.
 */

public class RegisterPresenter extends MyBasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    private final RegisterModel model;

    public RegisterPresenter() {
        model = new RegisterModel(this);
    }

    @Override
    public void register(String userName, String pwd) {
        getView().showLoading();
        model.register(userName, pwd);
    }

    @Override
    public void registerSuccess() {
        getView().hideLoading();
        getView().registerSuccess();
    }

    @Override
    public void registerFailure() {
        getView().hideLoading();
        getView().registerFailure();
    }

}
