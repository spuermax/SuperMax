package com.lt.library.base.presenter;

import android.util.Log;

import com.lt.library.base.model.func.IBaseModel;
import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
import com.lt.library.utils.ReflectUtils;
/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:59
 */
public abstract class BasePresenter
        <T extends IBaseView, S extends IBaseModel> extends AbstractBasePresenter<T> implements IBasePresenter {

    protected S mModel;

    protected void dettatchHelper() {
        Log.d(TAG, "dettatchHelper: ");
    }

    /**
     * 配置当前view对象的辅助动画、弹窗
     */
    protected void attatchHelper() {
        Log.d(TAG, "configHelper:");
    }

    /**
     * 构建model对象 如果范型使用实体类，则 不需要重写该函数  该函数会自动初始化
     * 如果范型使用接口 则须重写该函数手动构建model对象 或者 另行构建model对象
     */
    protected void createModel() {
        Log.d(TAG, "createModel: ");
        mModel = ReflectUtils.createFromParameter(1, getClass());
    }
}
