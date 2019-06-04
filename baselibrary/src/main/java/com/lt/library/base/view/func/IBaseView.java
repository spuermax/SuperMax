package com.lt.library.base.view.func;

import android.os.Bundle;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:30
 */
public interface IBaseView<T> extends IAbstractBaseView<T> {

    void onResume();

    void onStart();

    void onStop();

    void onPause();

    void onSaveState(Bundle saveState);

    void onRestoreState(Bundle restoreState);

}
