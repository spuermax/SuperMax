package com.lt.library.base;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lt.library.base.model.func.IBaseModel;
import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
import com.lt.library.utils.ReflectUtils;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-06-11
 * Time: 16:59
 */
public class BaseActivity<T extends IBaseView,S extends IBaseModel> extends AbstractBaseActivity<T>
implements IBasePresenter {
    protected S mModel;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        configTransition();
        if (mModel == null)
            mModel = createModel();
    }

    protected S createModel() {
        return ReflectUtils.createFromParameter(1,getClass());
    }

}
