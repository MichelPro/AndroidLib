package com.michel.sample.mvp.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.michel.intrastructure.mvp.BaseActivity;
import com.michel.intrastructure.mvp.IBasePresenter;
import com.michel.intrastructure.mvp.IBaseView;

/**
 * 如果你只是简单实用mvp框架，那么你只需要阅读ui包下的login的写法即可。
 *
 * 如果你存在特殊需求，如下所述，你需要参考register包下的写法。
 *
 * 你需要自己的MyBaseActivity来定义一些init方法，那么可以继承自BaseActivity
 *
 * 如果你的View层需要自定义一些公有方法交由P层调用，比如showLoading，那么需要自定义一个MyIBaseView接口继承自IBaseView
 * 注意：mvp中泛型声明时涉及的V，不再继承自IBaseView，而是继承自MyIBaseView，这样就可以在Presenter中统一调用
 */
public abstract class MyBaseActivity<V extends MyIBaseView<P>, P extends IBasePresenter<V>> extends BaseActivity<V, P> implements MyIBaseView<P> {

    private ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView方法大可不必再调用
        // 接下来可以自定义一些自己的方法
        init();
    }


    protected void init() {
        // init 一些必要view，比如dialog
        initLoadingDialog();
    }

    private void initLoadingDialog() {
        loadingDialog = new ProgressDialog(this);
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loadingDialog.setCancelable(false);
    }


    @Override
    public void showLoading() {
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void requestError(String errorMsg) {
        hideLoading();
        Log.d("Sample-mvp", errorMsg);
    }
}
