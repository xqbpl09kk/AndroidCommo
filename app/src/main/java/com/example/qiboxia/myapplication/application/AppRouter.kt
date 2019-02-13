package com.example.qiboxia.myapplication.application

import android.content.Intent
import com.example.qiboxia.myapplication.base.activity.BaseActivity

/**
 * 文 件 名: AppRouter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/13 15:39
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object AppRouter {

    public fun switchByCode(code : Int , params : HashMap<String, Any >?=null , requestCode :Int = 0  ){
        when(code ){
        }
    }


    public fun switchByClass(clazz  : Class<BaseActivity> , params : HashMap<String, Any >?=null , requestCode :Int = 0  ){

    }


    private fun jump(intent : Intent ,requestCode: Int){
        val currentActivity =  SApplication.getInstance().currentActivity()
        if(currentActivity == null ){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            SApplication.getInstance().startActivity(intent)
        }else{
            currentActivity?.startActivity(intent)
        }

    }
}