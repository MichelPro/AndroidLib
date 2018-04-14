package com.michel.intrastructure.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * MVP-BasePresenter
 * 定义一些Presenter的生命周期方法
 * 用于与Activity进行同步
 * Created by Michel on 2018/3/27.
 */

public interface IBasePresenter<V extends IBaseView>{

    V getView();

    void onCreatePresenter(@Nullable Bundle savedState);

    void onAttachView(V view);

    void onDetachView();

    void onDestroyPresenter();

    void onSaveInstanceState(Bundle savedState);

}
