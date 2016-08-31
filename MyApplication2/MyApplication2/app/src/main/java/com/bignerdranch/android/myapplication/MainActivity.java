package com.bignerdranch.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entity.User;
import peresenter.UserLoginPeresenter;
import view.UserLoginView;

public class MainActivity extends MVPBaseActivity<UserLoginView,UserLoginPeresenter> implements UserLoginView{
    EditText username,pwd;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mPresenter=createPresenter();
        mPresenter.attachView(this);
        initView();
    }

    private void initView() {
        username= (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mPresenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPwd() {
        return pwd.getText().toString();
    }

    @Override
    public void showFailMsg() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMain(User user) {
        startActivity(new Intent(this,HelloActivity.class));
    }

    @Override
    protected UserLoginPeresenter createPresenter() {
        return new UserLoginPeresenter(this);
    }

 /*   @Override
    protected UserLoginPeresenter createPresenter() {
        return new UserLoginPeresenter(this);
    }*/
}
