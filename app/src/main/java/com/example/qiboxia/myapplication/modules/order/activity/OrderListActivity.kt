package com.example.qiboxia.myapplication.modules.order.activity

import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.modules.order.adapter.OrderListAdapter
import com.example.qiboxia.myapplication.modules.order.adapter.holder.OrderHolder
import com.example.qiboxia.myapplication.base.activity.BaseListActivity
import com.example.qiboxia.myapplication.network.data.OrderListItem

/**
 * 文 件 名: OrderListActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 15:15
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class OrderListActivity : BaseListActivity<OrderListItem , OrderHolder ,OrderListAdapter>(){
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