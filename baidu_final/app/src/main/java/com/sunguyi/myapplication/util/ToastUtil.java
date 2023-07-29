package com.sunguyi.myapplication.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static Toast mToost;
    public static void showMsg(Context context,String msg)
    {
        if(mToost==null)
        {
            mToost=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
        else {
            mToost.setText(msg);
        }
        mToost.show();
    }
}
