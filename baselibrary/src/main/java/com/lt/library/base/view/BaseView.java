package com.lt.library.base.view;

import android.util.Log;

import com.lt.library.base.model.func.IBaseModel;
import com.lt.library.base.presenter.func.IBasePresenter;
import com.lt.library.base.view.func.IBaseView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-05-29
 * Time: 15:58
 */
public class BaseView<T,S extends IBasePresenter> extends AbstractBaseView<T> implements IBaseView<T> {
    protected S mPresenter;
    protected final String TAG ;
    {
        String simpleName = getClass().getSimpleName();
        int length = simpleName.length();
        TAG = length >= 20 ? simpleName.substring(length - 20) : simpleName;
    }

    @Override
    public void attatch(T t) {
        super.attatch(t);
        if (mPresenter == null)
            createPresenter();
        if (mPresenter != null)
            mPresenter.attatch(this);
    }

    @Override
    public void onResume() {
        if (mPresenter != null)
            mPresenter.onResume();
    }

    @Override
    public void onPause() {
        if (mPresenter != null)
            mPresenter.onPause();
    }
    /**
     * 构建model对象 如果范型使用实体类，则 不需要重写该函数  该函数会自动初始化
     * 如果范型使用接口 则须重写该函数手动构建model对象 或者 另行构建model对象
     */
    protected void createPresenter() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)){
            Log.d(TAG, "createModel: model is null");
            return;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (actualTypeArguments == null || actualTypeArguments.length <= 0){
            Log.d(TAG, "createModel: model is null");
            return;
        }
        for (Type actualTypeArgument : actualTypeArguments) {
            Class clazz = (Class) actualTypeArgument;
            if (!clazz.isInterface() && clazz.isAssignableFrom(IBasePresenter.class)) {
                try {
                    mPresenter = (S) clazz.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
