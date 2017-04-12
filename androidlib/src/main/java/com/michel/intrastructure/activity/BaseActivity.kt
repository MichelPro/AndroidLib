package com.michel.intrastructure.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.michel.intrastructure.utils.*

/**
 * Activity 基类
 * Created by Michel on 2017/3/29.
 */

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        initVariables()

        initViews(savedInstanceState!!)

        initData()

        LogD(javaClass.simpleName)
    }



    protected abstract val layoutResId: Int

    protected abstract fun initVariables()

    protected abstract fun initViews(savedInstanceState: Bundle)

    protected abstract fun initData()
}
