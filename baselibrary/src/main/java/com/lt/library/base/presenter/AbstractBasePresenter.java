package com.lt.library.base.presenter;
import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:52
 */
public abstract class AbstractBasePresenter<T extends IAbstractBaseView> implements IAbstractBasePresenter<T> {
    protected T mView;
    @Override
    public void attatch(T t) {
        this.mView = t;
    }

    @Override
    public void dettatch() {
        mView = null;
    }
}
