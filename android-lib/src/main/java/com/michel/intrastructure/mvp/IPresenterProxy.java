package com.michel.intrastructure.mvp;

/**
 * MVP-Presenter Proxy
 * Created by Michel on 2018/3/27.
 */

public interface IPresenterProxy<V extends IBaseView<P>, P extends IBasePresenter<V>> {

    P getPresenter();

    /**
     * @param presenterFactory -- 自定义PresenterFactory
     */
    void setPresenterFactory(IPresenterFactory<V, P> presenterFactory);

    IPresenterFactory<V, P> getPresenterFactory();
}
