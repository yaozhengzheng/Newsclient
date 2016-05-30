package com.yao.feicui.newsclient.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.yao.feicui.newsclient.common.LogUtil;

/**
 * Created by 16245 on 2016/05/30.
 */
public class MyBaseActivity extends Activity{
    protected int screen_w,screen_h;

    public void openActivity(Class<?>pClass, Bundle bundle, Uri uri){
        Intent intent=new Intent(this,pClass);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(LogUtil.TAG,getClass().getSimpleName()+"onStart()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screen_w=getWindowManager().getDefaultDisplay().getWidth();
        screen_h=getWindowManager().getDefaultDisplay().getHeight();
    }
}
