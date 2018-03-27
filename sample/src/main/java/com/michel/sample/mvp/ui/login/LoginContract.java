package com.michel.sample.mvp.ui.login;

import com.michel.intrastructure.mvp.IBaseModel;
import com.michel.intrastructure.mvp.IBasePresenter;
import com.michel.intrastructure.mvp.IBaseView;

/**
 * 如果不需要任何自定义过程，直接继承Lib中的MVP-Base的写法
 * Created by Michel on 2018/3/27.
 */

public interface LoginContract {

    interface View extends IBaseView<Presenter>{
        void loginSuccess();

        void loginFailure();
    }

    interface Presenter extends IBasePresenter<View>{
        void login(String userName, String password);

        void loginSuccess();

        void loginFailure();
    }

    interface Model extends IBaseModel{
        void login(String userName, String password);
    }


}
