package com.lt.library.base.view;

import android.view.View;

import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public abstract class BaseView<T extends IBasePresenter> extends AbstractBaseView<T> implements IBaseView<T> {
    @Override
    public void attatch(View contentView, T mPresenter) {
        super.attatch(contentView, mPresenter);
        initView();
        initListener();
    }
    protected abstract void initListener();
    protected abstract void initView();
    protected abstract void destoryView();
}
