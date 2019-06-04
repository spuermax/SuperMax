package com.lt.library.base.view.func;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:30
 */
public interface IAbstractBaseView<T> {

    void attatch(T t);

    void dettatch();

}
