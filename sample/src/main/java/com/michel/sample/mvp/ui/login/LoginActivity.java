package com.michel.sample.mvp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.michel.intrastructure.mvp.BaseActivity;
import com.michel.intrastructure.mvp.CreatePresenter;
import com.michel.sample.R;

/**
 * 如果不需要任何自定义过程，直接继承Lib中的MVP-Base的写法
 */
@CreatePresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View{

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        EditText etUserName = (EditText) findViewById(R.id.login_user_name);
        EditText etPwd = (EditText) findViewById(R.id.login_user_pwd);
        findViewById(R.id.login_login).setOnClickListener(v -> {
            String userName = etUserName.getText().toString();
            String password = etPwd.getText().toString();
            getPresenter().login(userName, password);
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "loginSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "loginFailure", Toast.LENGTH_SHORT).show();
    }
}
