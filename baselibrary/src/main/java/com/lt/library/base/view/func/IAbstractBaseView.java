package com.lt.library.base.view.func;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
