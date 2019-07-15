package com.lt.library.base.view.func;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lt.library.base.presenter.func.IAbstractBasePresenter;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:30
 */
public interface IAbstractBaseView<T extends IAbstractBasePresenter> {

    void attatch(View contentView, T mPresenter);

    View attatch(LayoutInflater inflater, ViewGroup rootGroup, T mPresenter);

    void dettatch();
}
