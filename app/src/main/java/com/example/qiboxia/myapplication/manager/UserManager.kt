package com.example.qiboxia.myapplication.manager

import android.app.Activity
import com.example.qiboxia.myapplication.application.SApplication
import com.example.qiboxia.myapplication.base.activity.ServiceBindActivity
import com.example.qiboxia.myapplication.base.listener.LoginStatusListener
import com.example.qiboxia.myapplication.network.data.OAuthUser
import com.example.qiboxia.myapplication.utils.rxjava.add
import io.reactivex.Observable

/**
 * 文 件 名: UserManager
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 15:52
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object UserManager : IUser {
    private var currentUser: OAuthUser? = null

    override fun onLogin(user: OAuthUser): Boolean {
        currentUser = user
        SpManager.saveLoginUser(user)
        for (activity in SApplication.getInstance().getActivities()) {
            if (activity is LoginStatusListener) {
                activity.onLogin(user)
            }
        }
        for (fragment in SApplication.getInstance().getFragments()) {
            if (fragment is LoginStatusListener) {
                fragment.onLogin(user)
            }
        }
        return true
    }

    override fun onLogout(): Boolean {
        currentUser = null
        SpManager.clearLoginUser()
        val activities = SApplication.getInstance().getActivities()
        Observable.fromIterable(activities)
                .filter { it is LoginStatusListener }
                .map { it as LoginStatusListener }
                .subscribe { it.onLogout() }
                .add("Login")
        val fragments = SApplication.getInstance().getFragments()
        Observable.fromIterable(fragments)
                .filter { it is LoginStatusListener }
                .map { it as LoginStatusListener }
                .subscribe{it.onLogout()}
                .add("Login")
        return true
    }
}

interface IUser {
    fun onLogin(user: OAuthUser): Boolean
    fun onLogout(): Boolean
}
