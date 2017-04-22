package com.jh.sh.jhsdk.util;

import android.content.Context;

/**
 * Created by phoenix on 2017/4/22.
 */

public class DialogUtil {

    public static void showDialog(Context context, String msg) {

    }

    public static void showDialog(Context context, int resId, Object... formatArgs) {
        showDialog(context, context.getString(resId, formatArgs));
    }
}
