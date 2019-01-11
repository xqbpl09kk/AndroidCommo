/**
 * 文 件 名: ServiceBindActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:41
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity;

import org.greenrobot.eventbus.EventBus

/**
 * 文 件 名: ServiceBindActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:41
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class ServiceBindActivity : BaseActivity() {

    override fun registerView() {
        super.registerView()
        registerBound()
    }

    private fun registerBound(){
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    abstract fun networkStep()
}
