package com.simon.mybilibili.controller;

import com.simon.mybilibili.listener.IModelChangeListener;

/**
 * Created by simon on 2017/5/17.
 */

public abstract class BaseController {

    protected IModelChangeListener mListener;

    public void sendAsyncMessage(final int action, final Object...values) {
        new Thread(){
            @Override
            public void run() {
                handleMessage(action,values);
            }
        }.start();
    }

    public abstract void handleMessage(int action, Object[] values) ;

    public void setIModelChangeListener(IModelChangeListener listener) {
        this.mListener = listener;
    }
}
