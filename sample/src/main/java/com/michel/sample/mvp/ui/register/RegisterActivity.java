package com.michel.sample.mvp.ui.register;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.michel.intrastructure.mvp.CreatePresenter;
import com.michel.sample.R;
import com.michel.sample.mvp.base.MyBaseActivity;

/**
 * 这里继承自自定义的MyBaseActivity，并实现Contract中的View接口
 */
@CreatePresenter(RegisterPresenter.class)
public class RegisterActivity extends MyBaseActivity<RegisterContract.View, RegisterContract.Presenter> implements RegisterContract.View {

    public static void start(Context context) {
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

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
        EditText etUserName = (EditText) findViewById(R.id.register_user_name);
        EditText etPwd = (EditText) findViewById(R.id.register_user_pwd);
        findViewById(R.id.register_register).setOnClickListener(v -> {
            String userName = etUserName.getText().toString();
            String password = etPwd.getText().toString();
            // 点击事件
            getPresenter().register(userName, password);
        });
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
