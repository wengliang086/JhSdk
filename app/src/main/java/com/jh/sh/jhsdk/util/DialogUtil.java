package com.jh.sh.jhsdk.util;

import android.app.Activity;
import android.content.Context;

import com.jh.sh.jhsdk.view.MyDialog;

/**
 * Created by phoenix on 2017/4/22.
 */
public class DialogUtil {

    public static void showDialog(Activity activity, String msg) {
        MyDialog myDialog = new MyDialog();
        myDialog.show(activity.getFragmentManager(), myDialog.getClass().getName());
    }

    public static void showDialog(Activity activity, int resId, Object... formatArgs) {
        showDialog(activity, activity.getString(resId, formatArgs));
    }
}
