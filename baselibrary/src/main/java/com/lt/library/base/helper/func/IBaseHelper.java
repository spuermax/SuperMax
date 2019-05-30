package com.lt.library.base.helper.func;

import com.lt.library.base.presenter.func.IBasePresenter;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:24
 */
public interface IBaseHelper<T extends IBasePresenter> {
    void onResume();
    void onPause();
    void attatch(T mPresenter);
    void dettatch();
}
