package com.lt.library.base.presenter.func;

import com.lt.library.base.view.func.IBaseView;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:29
 */
public interface IBasePresenter<T extends IBaseView> extends IAbstractBasePresenter<T> {

    void onResume();

    void onPause();

}
