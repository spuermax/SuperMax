package com.lt.library.manager;


import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by Android Studio.
 * User: master
 * Date: 2019-06-11
 * Time: 09:36
 */
public class SuperManager {
    private static final SuperManager su = new SuperManager();
    public static SuperManager install(Application a){
        Utils.init(a);
        return su;
    }
}
