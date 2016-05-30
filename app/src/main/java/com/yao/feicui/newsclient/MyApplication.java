package com.yao.feicui.newsclient;

import android.app.Application;
import android.content.res.Configuration;

import com.yao.feicui.newsclient.common.LogUtil;

import java.util.HashMap;

/**
 * Created by 16245 on 2016/05/30.
 */
public class MyApplication extends Application{

    //用来保存整个应程序的数据
    private HashMap<String,Object>allData=new HashMap<>();

    //    存数据
    public void addAllData(String key,Object value){
        allData.put(key,value);
    }
    //  取数据
    public Object getAllData(String key){
        if(allData.containsKey(key)){
            return allData.get(key);
        }
        return null;
    }
    //删除一条数据
    public void delAllDataBykey(String key){
        if (allData.containsKey(key)){
            allData.remove(key);
        }
    }
    //删除所有数据
    public void delAllData(){
        allData.clear();
    }
    //单例模式
    private static MyApplication application;

    public static MyApplication getInstance(){
        LogUtil.d(LogUtil.TAG,"MyApplication onCreate");
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        LogUtil.d(LogUtil.TAG,"application oncreate");
    }
    /**
     * 内存不足的时候
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtil.d(LogUtil.TAG,"MyApplication onLowMemory");
    }
    /**
     * 结束的时候
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        LogUtil.d(LogUtil.TAG,"MyApplication onTerminate");
    }
    /**
     * 配置改变的时候
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.d(LogUtil.TAG,"MyApplication onConfigurationChanged");
    }
}
