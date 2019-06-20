package com.lt.library.base.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.CloseUtils;
import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;
import com.lt.library.utils.ReflectUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public abstract class AbstractBaseView<T extends IAbstractBasePresenter> implements IAbstractBaseView<T> {
    protected View contentView;
    protected T mPresenter;
    protected Context mContext = null;
    protected final String TAG;
    private Unbinder unbinder;
    protected Handler mainHandler;

    {
        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length <= 20 ? simpleName : simpleName.substring(length - 20);
    }

    /**
     * 将该模块 绑定到页面
     *
     * @param contentView 绑定该模块的对象 可以是 activity fragment 甚至是view service  每个对象对应单独的mvp分层
     */
    @Override
    public void attatch(View contentView,T mPresenter) {
        Log.d(TAG, "attatch: ");
        this.contentView = contentView;
        unbinder = ButterKnife.bind(this, contentView);
        mContext = getContext();
        this.mPresenter = mPresenter;
        mainHandler = new Handler(contentView.getContext().getMainLooper());
    }

    @Override
    public View attatch(LayoutInflater inflater, ViewGroup rootGroup,T mPresenter) {
        Log.d(TAG, "attatch: ");
        View inflate = inflater.inflate(layoutId(), rootGroup, false);
        attatch(inflate,mPresenter);
        return inflate;
    }

    protected int layoutId() {
        return 0;
    }

    /**
     * 释放绑定页面/view对象
     * 建议重写该函数 在该函数执行释放该页面绑定的所有资源
     */
    @Override
    public void dettatch() {
        Log.d(TAG, "dettatch: ");
        if (mainHandler != null)
            mainHandler.removeCallbacksAndMessages(null);
        mainHandler = null;
        if (unbinder != null)
            unbinder.unbind();
        this.contentView = null;
    }

    /**
     * 获取当前页面/控件的上下文 备用
     *
     * @return 当前页面/控件的上下文
     */
    private Context getContext() {
        Log.d(TAG, "getContext: ");
        return contentView.getContext();
    }
}
