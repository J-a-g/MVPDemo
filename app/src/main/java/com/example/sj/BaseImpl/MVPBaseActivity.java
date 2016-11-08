package com.example.sj.BaseImpl;

import android.app.Activity;
import android.os.Bundle;

import com.example.sj.Base.BasePresenter;

/**
 * Created by SJ on 2016.10.30. 这是一个基类
 */

public abstract class MVPBaseActivity <V, T extends BasePresenter<V>>extends Activity{
    protected  T mPresenter; //presenter对象

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detacheView();
    }

    protected abstract T createPresenter();
}
