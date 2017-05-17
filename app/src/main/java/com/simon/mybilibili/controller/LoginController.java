package com.simon.mybilibili.controller;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.simon.mybilibili.bean.RResult;
import com.simon.mybilibili.cons.ActionMessage;
import com.simon.mybilibili.cons.NetworkConstant;
import com.simon.mybilibili.utils.NetworkUtil;

import java.util.HashMap;

/**
 * Created by simon on 2017/5/17.
 */

public class LoginController extends BaseController{


    @Override
    public void handleMessage(int action, Object[] values) {
        switch (action){
            case ActionMessage.LOGIN_ACTION:
                RResult result = login((String) values[0], (String) values[1]);
                if(mListener!=null) {
                    mListener.onModelChanged(action,result);
                }
                break;
        }
    }

    private RResult login(String name, String pwd) {
        HashMap<String, String> params = new HashMap<>();

        params.put(NetworkConstant.LOGIN_USERNAME,name);
        params.put(NetworkConstant.LOGIN_PWD,pwd);
        Log.v("cherish233",params.toString());
        String jsonStr = NetworkUtil.doPost(NetworkConstant.LOGIN_URL, params);
        Log.v("cherish233",jsonStr);
        return JSON.parseObject(jsonStr, RResult.class);

    }
}
