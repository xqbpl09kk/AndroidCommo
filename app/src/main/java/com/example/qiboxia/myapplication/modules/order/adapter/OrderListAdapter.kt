/**
 * 文 件 名: OrderListAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 15:17
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.order.adapter;

import android.content.Context
import android.view.ViewGroup
import com.example.qiboxia.myapplication.modules.order.adapter.holder.OrderHolder
import com.example.qiboxia.myapplication.base.adapter.BaseAdapter
import com.example.qiboxia.myapplication.network.data.OrderListItem

class OrderListAdapter(context: Context) : BaseAdapter<OrderListItem, OrderHolder>(context) {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): OrderHolder {
        return OrderHolder(context, container)
    }




}
