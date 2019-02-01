/**
 * 文 件 名: ServiceBindActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:41
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity;

import com.example.qiboxia.myapplication.third_party.SignInEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * 文 件 名: ServiceBindActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:41
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class ServiceBindActivity<T> : BaseActivity() {

    protected var t :T ?= null

    override fun registerView() {
        super.registerView()
        registerBound()
        networkStep()
    }

    private fun registerBound(){
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    abstract fun networkStep()

    open fun onDataFetch(t :T){
        this.t = t
    }

    @Subscribe fun onEvent(event : SignInEvent){
        when(event.event){
            SignInEvent.UserEvent.USER_LOGIN ->{ // 用户已经登录
                networkStep()
            }
            SignInEvent.UserEvent.INVALIDATE  , SignInEvent.UserEvent.USER_LOGOUT->{ //用户已经登出,认证失效
                t = null
                registerView()
            }
        }
    }
}
