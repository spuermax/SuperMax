package com.lt.library.base.presenter;

import android.util.Log;

import com.lt.library.base.helper.animator.func.IBaseAnimatorHelper;
import com.lt.library.base.helper.window.func.IBaseWindowHelper;
import com.lt.library.base.model.func.IBaseModel;
import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;
import com.lt.library.utils.ReflectUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 14:59
 */
public abstract class BasePresenter
        <T extends IBaseView, S extends IBaseModel, N extends IBaseWindowHelper, M extends IBaseAnimatorHelper>
        extends AbstractBasePresenter<T> implements IBasePresenter<T> {

    protected S mModel;
    protected M mAnimatorHelper;
    protected N mWindowHelper;

    /**
     * 绑定  可以是 activity  fragment  view  等 其他任意对象
     *
     * @param t
     */
    @Override
    public void attatch(T t) {
        Log.d(TAG, "attatch: ");
        super.attatch(t);
        configHelper();
        if (mAnimatorHelper != null)
            mAnimatorHelper.attatch(this);
        if (mWindowHelper != null)
            mWindowHelper.attatch(this);
        if (mModel == null)
            createModel();
    }

    @Override
    public void dettatch() {
        Log.d(TAG, "dettatch: ");
        super.dettatch();
        if (mAnimatorHelper != null)
            mAnimatorHelper.dettatch();
        if (mWindowHelper != null)
            mWindowHelper.dettatch();
        if (mModel != null)
            mModel.release();
        mAnimatorHelper = null;
        mWindowHelper = null;
        mModel = null;
    }

    /**
     * 配置当前view对象的辅助动画、弹窗
     */
    protected void configHelper() {
        Log.d(TAG, "configHelper:");
    }

    /**
     * 所有生命周期进行绑定
     */
    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");
        if (mAnimatorHelper != null)
            mAnimatorHelper.onResume();
        if (mWindowHelper != null)
            mWindowHelper.onResume();
    }

    /**
     * 所有生命周期进行绑定
     */
    @Override
    public void onPause() {
        Log.d(TAG, "onPause: ");
        if (mAnimatorHelper != null)
            mAnimatorHelper.onPause();
        if (mWindowHelper != null)
            mWindowHelper.onPause();
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
