package com.michel.intrastructure.mvp;

import android.os.Bundle;
import android.util.Log;

/**
 * MVP-Presenter Proxy
 * Created by Michel on 2018/3/27.
 */
public class PresenterProxy<V extends IBaseView<P>, P extends IBasePresenter<V>> implements IPresenterProxy<V, P> {

    private IPresenterFactory<V, P> factory;
    private P presenter;
    private Bundle bundle;
    private boolean isAttachView;
    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    // step1: 默认通过构造方法接收IPresenterFactory的子类实现类
    public PresenterProxy(IPresenterFactory<V, P> presenterFactory) {
        factory = presenterFactory;
    }

    // step2: 通过PresenterFactory去实例化Presenter
    @Override
    public P getPresenter() {
        if (factory != null) {
            if (presenter == null) {
                presenter = factory.createPresenter();
                // 如果bundle中存在数据则进行数据恢复
                presenter.onCreatePresenter(bundle == null? null : bundle.getBundle(PRESENTER_KEY));
            }
        }
        Log.d("Michel-MVP", "Proxy getPresenter = " + presenter);
        return presenter;
    }
    //----------------start--------------------
    // step3: 自定义Presenter生命周期方法
    // step4: 交由外部调用进行V-P的绑定和解绑
    public void onResume(V view) {
        getPresenter();
        if (presenter != null && !isAttachView) {
            presenter.onAttachView(view);
            isAttachView = true;
        }
    }

    public void onDestory() {
        if (presenter != null) {
            onDetachView();
            presenter.onDestroyPresenter();
            presenter = null;
        }
    }

    /**
     * 如果View层被意外销毁
     * @return  将当前数据保存到View层的Bundle中，以便取回
     */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        getPresenter();
        if (presenter != null) {
            Bundle presenterBundle = new Bundle();
            presenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        Log.d("Michel-MVP", "Proxy onSaveInstanceState");
        return bundle;
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        bundle = savedInstanceState;
        Log.d("Michel-MVP", "Proxy onRestoreInstanceState");
    }

    private void onDetachView() {
        if (presenter != null && isAttachView) {
            presenter.onDetachView();
            isAttachView = false;

        }
    }
    //----------------end--------------------


    /**
     * 如果用户自定义了PresenterFactory，
     * 通过这个方法去设置自己的PresenterFactory
     * 但是要在getPresenter()方法之前调用
     * @param presenterFactory -- 自定义PresenterFactory
     */
    @Override
    public void setPresenterFactory(IPresenterFactory<V, P> presenterFactory) {
        if (presenter != null) {
            throw new IllegalArgumentException("这个方法只能在getMvpPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.factory = presenterFactory;
    }

    @Override
    public IPresenterFactory<V, P> getPresenterFactory() {
        return factory;
    }
}
