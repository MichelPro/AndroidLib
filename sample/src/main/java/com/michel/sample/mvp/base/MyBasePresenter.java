package com.michel.sample.mvp.base;

import com.michel.intrastructure.mvp.BasePresenter;
import com.michel.intrastructure.mvp.IBasePresenter;

/**
 * 自定义BasePresenter，定义连接失败之后的操作，交由所有的M层调用
 * Created by Michel on 2018/3/27.
 */

public class MyBasePresenter<V extends MyIBaseView> extends BasePresenter<V> implements IBasePresenter<V>{

    public void requestError(String errorMsg) {
        getView().requestError(errorMsg);
    }
}
