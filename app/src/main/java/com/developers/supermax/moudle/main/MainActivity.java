package com.developers.supermax.moudle.main;


import com.developers.supermax.moudle.main.func.IMainPresenter;
import com.developers.supermax.moudle.main.model.MainModel;
import com.developers.supermax.moudle.main.view.MainView;
import com.lt.library.base.BaseActivity;

public class MainActivity
        //extends BaseActivity<IMainView, IMainModel>
    extends BaseActivity<MainView, MainModel>
implements IMainPresenter {
//    @Override
//    protected IMainModel createModel() {
//        return new MainModel();
//    }
//
//    @Override
//    protected IMainView createView() {
//        return new MainView();
//    }
    //或者使用实体类范型 不需要实现这两个函数
}
