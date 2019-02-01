/**
 * 文 件 名: SApplication
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 15:13
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.application;

import android.app.Application
import com.example.common.app.LogUtils
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import java.util.*

/**
 * 文 件 名: SApplication
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 15:13
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class SApplication : Application() {

    private val TAG = "SApplication"

    companion object {

        private lateinit var instance : SApplication

        fun getInstance() : SApplication {
            return instance
        }
    }

    private val activityStack : Stack<BaseActivity> = Stack()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun addActivity(activity : BaseActivity){
        LogUtils.i(TAG , "add Activity : ${activity.localClassName} , $activity ")
        LogUtils.i(TAG  , "before add activity size is ${activityStack.size}")
        activityStack.add(activity)
        LogUtils.i(TAG  , "after add activity size is ${activityStack.size}")
    }

    fun removeActivity(activity : BaseActivity?= null){
        LogUtils.i(TAG , "removeActivity : ${activity?.localClassName} , $activity ")
        LogUtils.i(TAG  , "before removeActivity size is ${activityStack.size}")
        activity?.let {
            activityStack.remove(activity)
        } ?: "".let {
            activityStack.pop()
        }
        LogUtils.i(TAG  , "before removeActivity size is ${activityStack.size}")
    }

    fun currentActivity() : BaseActivity?{
        if(activityStack.isNotEmpty())
            return activityStack.lastElement()
        return null
    }

}
