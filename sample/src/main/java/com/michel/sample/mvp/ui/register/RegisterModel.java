package com.michel.sample.mvp.ui.register;

import android.os.Handler;

import com.michel.sample.mvp.base.MyBaseModel;


/**
 * 所有的M层需要accessToken，所以自定义MyBaseModel继承自BaseModel
 * Created by Michel on 2018/3/27.
 */

public class RegisterModel extends MyBaseModel implements RegisterContract.Model {

    private final RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void register(String userName, String pwd) {
        // 继承自MyBaseModel，可以拿到共有数据
        System.out.println(accessToken);

        // 模拟耗时操作
        new Handler().postDelayed(() -> {
            switch (userName) {
                case "Success":
                    // registerSuccess
                    presenter.registerSuccess();
                    break;
                case "Failure":
                    // registerFailure
                    presenter.registerFailure();
                    break;
                default:
                    // requestError, eg: time out
                    presenter.requestError(userName);
                    break;
            }
        }, 3000);




    }
}
