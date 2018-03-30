package com.michel.intrastructure.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * MVP-BaseActivity
 */
public abstract class BaseActivity<V extends IBaseView<P>, P extends IBasePresenter<V>> extends AppCompatActivity implements IBaseView<P>, IPresenterProxy<V, P>{

    // step1: 通过默认PresenterFactory创建Presenter，获得PresenterProxy
    private PresenterProxy<V, P> proxy = new PresenterProxy<>(PresenterFactory.<V, P>createFactory(getClass()));
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        if (savedInstanceState != null) {
            proxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Override
    public P getPresenter() {
        return proxy.getPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        proxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        proxy.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(PRESENTER_SAVE_KEY, proxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(IPresenterFactory<V, P> presenterFactory) {
        proxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public IPresenterFactory<V, P> getPresenterFactory() {
        return proxy.getPresenterFactory();
    }

    /**
     * @return 返回资源文件
     */
    protected abstract int getLayoutResId();
}
