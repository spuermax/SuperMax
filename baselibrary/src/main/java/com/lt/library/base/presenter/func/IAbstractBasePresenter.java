package com.lt.library.base.presenter.func;


import android.app.Dialog;

import androidx.appcompat.app.AlertDialog;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:29
 */
public interface IAbstractBasePresenter{
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

    void configTransition();
}
