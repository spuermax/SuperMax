package com.lt.library.base;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;
import com.lt.library.utils.ReflectUtils;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-06-05
 * Time: 10:47
 */
public class AbstractBaseFragment<T extends IAbstractBaseView> extends Fragment
        implements IAbstractBasePresenter {
    protected T mView;
    protected View contentView;
    protected final String TAG;

    {
        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length >= 20 ? simpleName.substring(length - 20) : simpleName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = createView();
        if (mView != null)
            contentView = mView.attatch(inflater, container,this);
        return contentView;
    }

    protected T createView() {
        return ReflectUtils.createFromParameter(0, getClass());
    }

    @Override
    public void onDestroyView() {
        if (mView != null)
            mView.dettatch();
        super.onDestroyView();
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
        showMsg(getString(msgRes));
    }

    @Override
    public void showLongMsg(int msgRes) {
        showLongMsg(getString(msgRes));
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
     * 配置转场动画  转场动画只有replease stack时可用
     */
    @Override
    public void configTransition() {

    }
}
