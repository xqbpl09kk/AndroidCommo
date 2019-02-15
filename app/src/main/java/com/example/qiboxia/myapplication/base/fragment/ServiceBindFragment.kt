/**
 * 文 件 名: ServiceBindFragment
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/14 11:41
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.fragment;

import com.example.qiboxia.myapplication.base.listener.LoginStatusListener
import com.example.qiboxia.myapplication.network.data.User

abstract class ServiceBindFragment : BaseFragment() , LoginStatusListener {
    abstract override fun onLogin(user: User)

    abstract override fun onLogout()
}
