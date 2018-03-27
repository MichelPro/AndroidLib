package com.michel.sample.mvp.base;

import com.michel.intrastructure.mvp.IBasePresenter;
import com.michel.intrastructure.mvp.IBaseView;

/**
 * View层存在业务中共用方法，抽取到接口中，交由MyBaseActivity自我实现
 * Created by Michel on 2018/3/27.
 */

public interface MyIBaseView<P extends IBasePresenter> extends IBaseView<P>{

    void showLoading();

    void hideLoading();

    void requestError(String errorMsg);
}
