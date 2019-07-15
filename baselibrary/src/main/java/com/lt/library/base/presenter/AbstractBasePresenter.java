package com.lt.library.base.presenter;

import android.app.Dialog;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:52
 */
public class AbstractBasePresenter<T extends IAbstractBaseView> implements IAbstractBasePresenter {
    protected T mView;
    protected final String TAG ;
    {
        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length >= 20 ? simpleName.substring(length - 20) : simpleName;
    }

    @Override
    public void showMsg(CharSequence msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    public void showLongMsg(CharSequence msg) {
        ToastUtils.showLong(msg);
    }

    @Override
    public void showMsg(String msg) {
        showMsg((CharSequence) msg);
    }

    @Override
    public void showLongMsg(String msg) {
        showLongMsg((CharSequence) msg);
    }

    @Override
    public void showMsg(int msgRes) {
        showMsg(ActivityUtils.getTopActivity().getString(msgRes));
    }

    @Override
    public void showLongMsg(int msgRes) {
        showLongMsg(ActivityUtils.getTopActivity().getString(msgRes));
    }

    @Override
    public void loading() {

    }

    @Override
    public void loading(Dialog dialog) {
        if (dialog == null)
            return;
        Window window = dialog.getWindow();
        if (window == null)
            return;
        if (!window.isActive()) {
            if (dialog.isShowing())
                dialog.dismiss();
            return;
        }
        if (dialog.isShowing())
            dialog.dismiss();
        dialog.show();
    }

    @Override
    public void loading(AlertDialog alertDialog) {
        loading((Dialog) alertDialog);
    }

    @Override
    public void loading(android.app.AlertDialog alertDialog) {
        loading((Dialog) alertDialog);
    }

    /**
     * 配置转场动画
     */
    @Override
    public void configTransition() {

    }
}
