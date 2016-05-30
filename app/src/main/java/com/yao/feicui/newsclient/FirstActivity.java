package com.yao.feicui.newsclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by 16245 on 2016/05/30.
 */
public class FirstActivity extends Activity{
    private ImageView mImageView;
    private Animation mAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mImageView = (ImageView) findViewById(R.id.iv_start);
        mAnimation= AnimationUtils.loadAnimation(this,R.anim.alpha);
        mImageView.startAnimation(mAnimation);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
