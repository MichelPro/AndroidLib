package com.michel.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.michel.sample.mvp.ui.login.LoginActivity;
import com.michel.sample.mvp.ui.register.RegisterActivity;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        initView();
    }

    private void initView() {
        // 无修改继承关系的mvpDemo
        findViewById(R.id.mvp_login).setOnClickListener(v -> LoginActivity.start(getApplicationContext()));
        // 修改继承关系的mvpDemo
        findViewById(R.id.mvp_register).setOnClickListener(v -> RegisterActivity.start(getApplicationContext()));
    }
}
