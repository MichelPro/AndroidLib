package com.michel.sample.mvp.ui.register;

import com.michel.intrastructure.mvp.IBaseModel;
import com.michel.intrastructure.mvp.IBasePresenter;
import com.michel.sample.mvp.base.MyIBaseView;

/**
 * 这是存在一些自定义需求
 * View的父类接口需要替换成自定义的MyIBaseView
 * Created by Michel on 2018/3/27.
 */

public interface RegisterContract {

    interface View extends MyIBaseView<Presenter>{
        void registerSuccess();

        void registerFailure();
    }

    interface Presenter extends IBasePresenter<View>{
        void register(String userName, String pwd);

        void registerSuccess();

        void registerFailure();
    }

    interface Model extends IBaseModel{
        void register(String userName, String pwd);
    }

}
