package com.lt.library.base.presenter.func;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;

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

    void showMsg(CharSequence msg);

    void showLongMsg(CharSequence msg);

    void showMsg(String msg);

    void showLongMsg(String msg);

    void showMsg(int msgRes);

    void showLongMsg(int msgRes);

    void loading();

    void loading(Dialog dialog);

    void loading(AlertDialog alertDialog);

    void loading(android.app.AlertDialog alertDialog);
}
