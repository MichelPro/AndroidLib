package com.michel.intrastructure.mvp;

/**
 * MVP-Presenter Factory Iml
 * Created by Michel on 2018/3/27.
 */

public class PresenterFactory<V extends IBaseView<P>, P extends IBasePresenter<V>> implements IPresenterFactory<V, P>{

    private final Class<P> presenterClass;

    // step3: 通过构造方法获取Presenter类名
    private PresenterFactory(Class<P> presenterClass) {
        this.presenterClass = presenterClass;
    }

    // step1: 外部调用createFactory，传入View类，获取View类之上的注解
    // step2: 将注解类的内容交给PresenterFactory的构造方法
    public static <V extends IBaseView<P>, P extends IBasePresenter<V>>PresenterFactory<V, P> createFactory(Class<?> viewClazz) {
        // 通过View类拿到注解
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> pClass = null;
        if (annotation != null) {
            // 通过注解获取Presenter类名
            pClass = (Class<P>) annotation.value();
        }
        return pClass == null ? null : new PresenterFactory<>(pClass);
    }

    // step4: 交由外部（即Proxy）调用，进行Presenter的实例化
    @Override
    public P createPresenter() {
        try {
            return presenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
