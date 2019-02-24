package com.example.qiboxia.myapplication.manager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.application.SApplication
import com.example.qiboxia.myapplication.modules._services.JobService

/**
 * 文 件 名: NotificationHandler
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/20 18:03
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object NotificationHandler {

//
//    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//    val intent = Intent(this , JobService::class.java)
//    val pendingIntent = PendingIntent.getService(this , 0 , intent , 0)
////        val notification = NotificationCompat.Builder(this , "1")
////                .setSmallIcon(R.mipmap.ic_launcher)
////                .setContentTitle("ceshitongzhi")
////                .setContentText("title")
////                .setAutoCancel(true)
////                .setContentIntent(pendingIntent)
////                .build()
////        notificationManager.notify(1001, notification)
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        val channel = NotificationChannel("1",
//                "xws", NotificationManager.IMPORTANCE_DEFAULT)
//        channel.enableLights(true) //是否在桌面icon右上角展示小红点
//        channel.lightColor = Color.RED //小红点颜色
//        channel.setShowBadge(true) //是否在久按桌面图标时显示此渠道的通知
//        notificationManager?.let {
//            it.createNotificationChannel(channel)
//        }
//
//        val notification = Notification.Builder(this, "1")
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("享物说")
//                .setContentText("content")
//                .setTimeoutAfter(System.currentTimeMillis())
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .build()// getNotification()
//
//        notificationManager?.let {
//            it.notify(1001, notification)
//        }
//    } else {
//        val notification = Notification.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentText("content")
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true)
//                .build()// getNotification()
//
//        notificationManager?.let {
//            it.notify(1001, notification)
//        }
//    }

    private val notifyManager  = SApplication.getInstance()
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showRongNotification(){
        //init intent
        //init pendingIntent
        //distribute os version
            //init channel
        //init notification
        //notify notification
    }

    fun showGetuiNotification(){
        //init intent
        //init pendingIntent
        //distribute os version
            //init channel
        //init notification
        //notify notification
    }


    private fun initNotification(){

    }
}



