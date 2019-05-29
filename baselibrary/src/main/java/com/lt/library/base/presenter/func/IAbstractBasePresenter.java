package com.lt.library.base.presenter.func;

import com.lt.library.base.view.func.IAbstractBaseView;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:29
 */
public interface IAbstractBasePresenter<T extends IAbstractBaseView> {
    void attatch(T t);

    void dettatch();
}
