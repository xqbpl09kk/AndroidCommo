package com.example.qiboxia.myapplication.base.listener

import com.example.qiboxia.myapplication.network.data.User

/**
 * 文 件 名: LoginStatusListener
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/14 11:40
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
interface LoginStatusListener {

    fun onLogin(user : User)

    fun onLogout()
}