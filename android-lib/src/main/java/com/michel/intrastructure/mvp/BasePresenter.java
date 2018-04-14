package com.michel.intrastructure.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * MVP-BasePresenter
 * Created by Michel on 2018/3/27.
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V view;

    @Override
    public V getView() {
        return view;
    }

    @Override
    public void onCreatePresenter(@Nullable Bundle savedState) {
        Log.d("Michel-MVP", "P onCreatePresenter");
    }

    @Override
    public void onAttachView(V view) {
        Log.d("Michel-MVP", "P onAttachView");
        this.view = view;
    }

    @Override
    public void onDetachView() {
        Log.d("Michel-MVP", "P onDetachView");
        view = null;
    }

    @Override
    public void onDestroyPresenter() {
        Log.d("Michel-MVP", "P onDestroyPresenter");
    }

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        Log.d("Michel-MVP", "P onSaveInstanceState");
    }
}
