package com.simon.mybilibili.bean;

/**
 * Created by xmg on 2017/5/11.
 */

public class RResult {

    private boolean success;
    private String errorMsg;
    private String result;//JSON字符串

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RResult{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
