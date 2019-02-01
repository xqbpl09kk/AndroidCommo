package com.example.qiboxia.myapplication.manager

import com.example.qiboxia.myapplication.network.data.OAuthUser

/**
 * 文 件 名: UserManager
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 15:52
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object UserManager : IUser{
    private var currentUser : OAuthUser?= null

    override fun onLogin(user: OAuthUser) : Boolean {
        currentUser = user
        SpManager.saveLoginUser(user)
        return true
    }

    override fun onLogout(): Boolean {
        currentUser = null
        SpManager.clearLoginUser()
        return true
    }
}

interface IUser{
    fun onLogin(user :OAuthUser) :Boolean
    fun onLogout() : Boolean
}
