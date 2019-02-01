/**
 * 文 件 名: JobService
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 17:23
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules._services;

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.qiboxia.myapplication.third_party.ServiceEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class JobService  : Service(){
    private var count = 0

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        Thread(Runnable {
            while(true){
                Log.e("JobService" , " running $count")
                count ++
            }
        }).start()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onEvent(event :ServiceEvent){
        Log.e("JobService" , "received event ${event.msg}")
    }
}
