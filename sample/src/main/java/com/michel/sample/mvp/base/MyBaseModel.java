package com.michel.sample.mvp.base;

import com.michel.intrastructure.mvp.BaseModel;

/**
 * 自定义BaseModel
 * Created by Michel on 2018/3/27.
 */

public class MyBaseModel extends BaseModel{

    protected String accessToken;

    public MyBaseModel() {
        // 如果你的网络请求大部分都需要添加token进行身份验证，你可以在BaseModel中进行获取
        accessToken = "accessToken";
    }
}
