package com.lt.library.base.view.func;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:30
 */
public interface IBaseView<T> extends IAbstractBaseView<T> {

    void onResume();

    void onPause();
}
