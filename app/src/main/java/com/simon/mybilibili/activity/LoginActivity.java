package com.simon.mybilibili.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.simon.mybilibili.R;
import com.simon.mybilibili.bean.RResult;
import com.simon.mybilibili.cons.ActionMessage;
import com.simon.mybilibili.controller.LoginController;
import com.simon.mybilibili.listener.IModelChangeListener;

public class LoginActivity extends BaseActivity implements View.OnClickListener , IModelChangeListener {

    private ImageView content_login_iv_22;
    private ImageView content_login_iv_33;
    private EditText content_login_tv_name;
    private EditText content_login_tv_pwd;
    private View mRegistBtn;
    private ImageView login_toolbar_iv_back;
    private Button content_login_btn_regist;
    private Button content_login_btn_login;
    private LoginController mLoginController;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            handleUI(msg);
        }
    };

    private void handleUI(Message msg) {
        if(msg.what==ActionMessage.LOGIN_ACTION) {
            RResult result = (RResult) msg.obj;
            if(result.isSuccess()) {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                actionStart(this,HomeActivity.class);
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        changeImage2233();
        initController();
    }

    private void initController() {
        mLoginController = new LoginController();
        mLoginController.setIModelChangeListener(this);

    }

    private void initView() {

        content_login_iv_22 = (ImageView) findViewById(R.id.content_login_iv_22);
        content_login_iv_33 = (ImageView) findViewById(R.id.content_login_iv_33);
        content_login_tv_name = (EditText) findViewById(R.id.content_login_tv_name);
        content_login_tv_pwd = (EditText) findViewById(R.id.content_login_tv_pwd);
        login_toolbar_iv_back = (ImageView) findViewById(R.id.login_toolbar_iv_back);
        login_toolbar_iv_back.setOnClickListener(this);
        content_login_btn_regist = (Button) findViewById(R.id.content_login_btn_regist);
        content_login_btn_regist.setOnClickListener(this);
        content_login_btn_login = (Button) findViewById(R.id.content_login_btn_login);
        content_login_btn_login.setOnClickListener(this);
    }

    public void changeImage2233() {
        content_login_tv_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    content_login_iv_22.setImageResource(R.mipmap.ic_22_hide);
                    content_login_iv_33.setImageResource(R.mipmap.ic_33_hide);
                } else {
                    content_login_iv_22.setImageResource(R.mipmap.ic_22);
                    content_login_iv_33.setImageResource(R.mipmap.ic_33);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content_login_btn_regist:
                registClick();
                break;
            case R.id.content_login_btn_login:
                loginClick();
                break;
            case R.id.login_toolbar_iv_back:
                finish();
                break;
        }
    }

    private void loginClick() {
        String name = content_login_tv_name.getText().toString();
        String pwd = content_login_tv_pwd.getText().toString();

        mLoginController.sendAsyncMessage(ActionMessage.LOGIN_ACTION, name,pwd);
    }

    private void registClick() {

    }

    @Override
    public void onModelChanged(int action, Object resultBean) {
        handler.obtainMessage(action,resultBean).sendToTarget();
    }
}
