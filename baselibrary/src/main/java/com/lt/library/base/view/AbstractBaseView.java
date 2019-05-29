package com.lt.library.base.view;

import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public class AbstractBaseView<T> implements IAbstractBaseView<T> {
    protected T mView;
    @Override
    public void attatch(T t) {
        this.mView = t;
    }

    @Override
    public void dettatch() {
        this.mView = null;
    }
}
