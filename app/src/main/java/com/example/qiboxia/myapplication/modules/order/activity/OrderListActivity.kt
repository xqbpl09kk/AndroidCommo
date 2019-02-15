package com.example.qiboxia.myapplication.modules.order.activity

import android.content.Intent
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.modules.order.adapter.OrderListAdapter
import com.example.qiboxia.myapplication.modules.order.adapter.holder.OrderHolder
import com.example.qiboxia.myapplication.base.activity.BaseListActivity
import com.example.qiboxia.myapplication.base.activity.ScrollPageActivity
import com.example.qiboxia.myapplication.base.fragment.BaseFragment
import com.example.qiboxia.myapplication.modules.order.fragment.OrderListFragment
import com.example.qiboxia.myapplication.network.data.OrderListItem
import com.example.qiboxia.myapplication.network.data.User

/**
 * 文 件 名: OrderListActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 15:15
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class OrderListActivity : ScrollPageActivity(){
    override fun getFragmentList(): ArrayList<out BaseFragment> {
        val arrayList = arrayListOf<OrderListFragment>()
        arrayList.add(OrderListFragment())
        arrayList.add(OrderListFragment())
        arrayList.add(OrderListFragment())
        return arrayList
    }

    override fun getActTitle(): String {
        return getString(R.string.my_order)
    }


}