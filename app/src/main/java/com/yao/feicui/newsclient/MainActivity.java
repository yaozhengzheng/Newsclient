package com.yao.feicui.newsclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  ViewPager.OnPageChangeListener {
    public static final String SPLASH_CONFIG="splash_config";
    public static final String IS_FIRST_RUN="isFirstRun";
    private ViewPager mViewPager;
    private ArrayList<View> mList;
    int[] pics = {R.mipmap.bd, R.mipmap.wy, R.mipmap.small, R.mipmap.welcome};
    ImageView iv_1, iv_2, iv_3, iv_4;
    ImageView[] pics1 = {iv_1, iv_2, iv_3, iv_4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否是第一次运行程序
        SharedPreferences preferences = getSharedPreferences(SPLASH_CONFIG, MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean(IS_FIRST_RUN,true);
        if (!isFirstRun) {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_main);
            initView();
        }
    }
//滚动式调用方法，反复调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private void initView() {
        mList = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.vp);
        pics1[0] = (ImageView) findViewById(R.id.iv_1);
        pics1[1] = (ImageView) findViewById(R.id.iv_2);
        pics1[2] = (ImageView) findViewById(R.id.iv_3);
        pics1[3] = (ImageView) findViewById(R.id.iv_4);
        pics1[0].setImageResource(R.mipmap.adware_style_selected);
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(pics[i]);
            mList.add(iv);
            Log.d("aaaa", String.valueOf(iv));
        }
        mViewPager.setAdapter(new MyPagerAdapter(mList));
        mViewPager.addOnPageChangeListener(this);
    }



    //当达到最后一个画面时跳转，1秒
    @Override
    public void onPageSelected(int position) {
        if (position==3) {
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                    startActivity(intent);
                    finish();
                }
            },1000);

        }
        //更新图标
        for (int i = 0; i < pics.length; i++) {
            pics1[i].setImageResource(R.mipmap.adware_style_default);
        }
        pics1[position].setImageResource(R.mipmap.adware_style_selected);
    }
//viewpager在滚动的时候调用第一个方法
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyPagerAdapter extends PagerAdapter {
        private ArrayList<View> mList;

        public MyPagerAdapter(ArrayList<View> list) {
            mList = list;
        }

        //初始化里面的视图,展现到界面上来
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }

        //当不可见是销毁position
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }

//        获得viewpager中有多少个view
        @Override
        public int getCount() {
            if (mList != null) {
                return mList.size();
            }
            return 0;
        }

        /**
         * 判断instantiateItem(ViewGroup, int)函数
         * 所返回来的Key与一个页面视图是否是 代表的同一个视图
          */

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
