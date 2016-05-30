package com.yao.feicui.newsclient.common;

import android.util.Log;

/**
 * Created by 16245 on 2016/05/30.
 */
public class LogUtil {
    public static final String TAG = "新闻随意看";
    //调试日志开关
    public static boolean isDebug=true;
    public static void d(String tag, String msg){
        if(isDebug){
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(LogUtil.TAG,msg);
    }
}
