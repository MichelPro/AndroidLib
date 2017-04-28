package com.michel.sample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.michel.intrastructure.activity.BaseActivity;

public abstract class AppBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
