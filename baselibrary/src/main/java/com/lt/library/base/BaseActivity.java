package com.lt.library.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

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
    protected void jump(Class<? extends Activity> to) {
        jump(to, false);
    }

    protected void jump(Class<? extends Activity> to, boolean finish) {
        Intent intent = new Intent(this, to);
        jump(intent,finish);
    }

    protected void jump(Intent to) {
        jump(to, false);
    }
    protected Bundle finishTransition(){
        return ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle();
    }
    protected void jump(Intent to, boolean finish) {
        Bundle bundle = finishTransition();
        if (bundle == null) {
            startActivity(to);
            if (finish)
                finish();
            return;
        }
        startActivity(to,bundle);
        if (finish)
            finishAfterTransition();
    }

    protected void jump(String action) {
        jump(action, false);
    }

    protected void jump(String action, boolean finish) {
        Intent intent = new Intent();
        intent.setAction(action);
        jump(intent,finish);
    }

}
