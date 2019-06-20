package com.lt.library.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.lt.library.base.model.func.IBaseModel;
import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
import com.lt.library.utils.ReflectUtils;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-06-11
 * Time: 17:40
 */
public class BaseFragment<T extends IBaseView,S extends IBaseModel> extends AbstractBaseFragment<T>
implements IBasePresenter{
    protected S mModel;
    protected Bundle params;

    public void setParams(Bundle params) {
        this.params = params;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mModel == null)
            mModel = createModel();
    }

    protected S createModel() {
        return ReflectUtils.createFromParameter(1,getClass());
    }
}
