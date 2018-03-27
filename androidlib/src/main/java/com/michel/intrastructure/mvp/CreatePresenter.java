package com.michel.intrastructure.mvp;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * MVP-Annotation
 * 通过注解去创建Presenter
 * Created by Michel on 2018/3/27.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {

    Class<? extends IBasePresenter> value();
}
