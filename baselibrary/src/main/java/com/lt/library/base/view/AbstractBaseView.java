package com.lt.library.base.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;
import com.lt.library.utils.ReflectUtils;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public class AbstractBaseView<T, S extends IAbstractBasePresenter> implements IAbstractBaseView<T> {
    protected T mContent;
    protected S mPresenter;
    protected Context mContext = null;
    protected final String TAG;

    {
        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length <= 20 ? simpleName : simpleName.substring(length - 20);
    }

    @Override
    public void attatch(T t) {
        Log.d(TAG, "attatch: ");
        this.mContent = t;
        mContext = getContext();
        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attatch(this);
    }

    protected S createPresenter() {
        Log.d(TAG, "createPresenter: ");
        mPresenter = ReflectUtils.createFromParameter(1, getClass());
        return mPresenter;
    }

    @Override
    public void dettatch() {
        Log.d(TAG, "dettatch: ");
        this.mContent = null;
        if (mPresenter != null)
            mPresenter.dettatch();
    }

    private Context getContext() {
        Log.d(TAG, "getContext: ");
        if (mContent instanceof Context)
            return mContext = (Context) mContent;
        if (mContent instanceof Fragment)
            return mContext = ((Fragment) mContent).getContext();
        if (mContent instanceof View)
            return mContext = ((View) mContent).getContext();
        return mContext;
    }
}
