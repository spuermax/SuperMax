package com.lt.library.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.blankj.utilcode.util.CloseUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lt.library.base.presenter.func.IAbstractBasePresenter;
import com.lt.library.base.view.func.IAbstractBaseView;
import com.lt.library.utils.ReflectUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-06-05
 * Time: 10:47
 */
public abstract class AbstractBaseActivity<T extends IAbstractBaseView> extends FragmentActivity
implements IAbstractBasePresenter {
    protected Handler mainHandler;
    protected T mView;
    protected final String TAG;
    private View mRootView;
    {

        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length <= 20 ? simpleName : simpleName.substring(length - 20);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "onPostCreate: ");
        mView = createView();
        mainHandler = new Handler(getMainLooper());
        if (mView != null)
            setContentView(mView.attatch(getLayoutInflater(), null,this));
        mRootView = getWindow().getDecorView();
    }

    protected T createView() {
        Log.d(TAG, "createView: ");
        return ReflectUtils.createFromParameter(0, getClass());
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        if (mainHandler != null)
            mainHandler.removeCallbacksAndMessages(null);
        mainHandler = null;
        if (mView != null)
            mView.dettatch();
        mView = null;
        super.onDestroy();
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
     * 配置转场动画
     */
    @Override
    public void configTransition() {

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        View currentFocus = getCurrentFocus();
        if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
            /*隐藏软键盘*/
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if(inputMethodManager.isActive()){
                if (currentFocus != null)
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            if (currentFocus != null){
                mRootView.setClickable(true);
                mRootView.setFocusable(true);
                mRootView.setFocusableInTouchMode(true);
                mRootView.requestFocusFromTouch();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    mRootView.setClickable(true);
                    mRootView.setFocusable(true);
                    mRootView.setFocusableInTouchMode(true);
                    mRootView.requestFocusFromTouch();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }
}
