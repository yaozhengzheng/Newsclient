package com.yao.feicui.newsclient;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private Button mButton;
    private ViewPager mViewPager;
    private ArrayList<View> mList;
    int[] pics = {R.mipmap.bd, R.mipmap.wy, R.mipmap.small, R.mipmap.welcome};
    ImageView iv_1, iv_2, iv_3, iv_4;
    ImageView[] pics1 = {iv_1, iv_2, iv_3, iv_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private void initView() {
        mList = new ArrayList<>();
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    //当达到最后一个画面时显示按钮
    @Override
    public void onPageSelected(int position) {
        mButton.setVisibility(View.INVISIBLE);
        if (position >= 3) {
            mButton.setVisibility(View.VISIBLE);
        } else {
            mButton.setVisibility(View.INVISIBLE);
        }
        //更新图标
        for (int i = 0; i < pics.length; i++) {
            pics1[i].setImageResource(R.mipmap.adware_style_default);
        }
        pics1[position].setImageResource(R.mipmap.adware_style_selected);
    }

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

        @Override
        public int getCount() {
            if (mList != null) {
                return mList.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
