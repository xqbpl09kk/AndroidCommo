package com.example.qiboxia.myapplication.modules.order.activity

import android.content.Intent
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.modules.order.adapter.OrderListAdapter
import com.example.qiboxia.myapplication.modules.order.adapter.holder.OrderHolder
import com.example.qiboxia.myapplication.base.activity.BaseListActivity
import com.example.qiboxia.myapplication.network.data.OrderListItem
import com.example.qiboxia.myapplication.network.data.User

/**
 * 文 件 名: OrderListActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 15:15
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class OrderListActivity : BaseListActivity<OrderListItem , OrderHolder ,OrderListAdapter>(){
    override fun onLogin(user: User) {

    }

    override fun onLogout() {
    }

    override fun initAdapter(): OrderListAdapter {
        return OrderListAdapter(this)
    }

    override fun networkStep() {
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_order_list
    }

    override fun getActTitle(): String {
        return getString(R.string.order_list)
    }



}