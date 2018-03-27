package com.michel.intrastructure.mvp;

/**
 * MVP-Presenter Factory
 * Created by Michel on 2018/3/27.
 */

public interface IPresenterFactory<V extends IBaseView<P>, P extends IBasePresenter<V>> {

    P createPresenter();
}
