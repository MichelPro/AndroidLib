package com.michel.sample.mvp.ui.register;

import android.widget.Toast;
import com.michel.sample.R;
import com.michel.sample.mvp.base.MyBaseActivity;

/**
 * 这里继承自自定义的MyBaseActivity，并实现Contract中的View接口
 */
public class RegisterActivity extends MyBaseActivity<RegisterContract.View, RegisterContract.Presenter> implements RegisterContract.View {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        super.init();

        initView();
    }

    private void initView() {
        // 点击事件
        getPresenter().register("userName", "pwd");
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "registerSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFailure() {
        Toast.makeText(this, "registerFailure", Toast.LENGTH_SHORT).show();
    }
}
