package com.example.sj.Base;

import android.view.View;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by SJ on 2016.10.30.
 */

public abstract class BasePresenter<T>{
    protected Reference<T> mViewRef;

    //与View建立关联
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }
    //获取View
    protected T getView(){
        return mViewRef.get();
    }
    //判断是否与View建立了连接
    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }
    //解除关联
    public void detacheView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
