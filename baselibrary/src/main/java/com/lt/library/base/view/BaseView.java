package com.lt.library.base.view;

import android.os.Bundle;
import android.util.Log;

import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public class BaseView<T,S extends IBasePresenter> extends AbstractBaseView<T,S> implements IBaseView<T> {
    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");
        if (mPresenter != null)
            mPresenter.onResume();
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: ");
        if (mPresenter != null)
            mPresenter.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: ");
        if (mPresenter != null)
            mPresenter.onStop();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause: ");
        if (mPresenter != null)
            mPresenter.onPause();
    }

    @Override
    public void onSaveState(Bundle saveState) {
        Log.d(TAG, "onSaveState: ");
        if (mPresenter != null)
            mPresenter.onSaveState(saveState);
    }

    @Override
    public void onRestoreState(Bundle restoreState) {
        Log.d(TAG, "onRestoreState: ");
        if (mPresenter != null)
            mPresenter.onRestoreState(restoreState);
    }
}
