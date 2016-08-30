package com.bignerdranch.android.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import peresenter.BasePesenter;

/**
 * Created by Administrator on 2016/8/30.
 */
public abstract class MVPBaseActivity<V,T extends BasePesenter<V>> extends AppCompatActivity {
    protected T mPresenter;//

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
    protected  abstract T createPresenter();
}
