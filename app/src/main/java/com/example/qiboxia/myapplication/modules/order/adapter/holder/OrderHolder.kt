/**
 * 文 件 名: OrderHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 15:20
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.order.adapter.holder;

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.example.common.app.ToastManager
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.adapter.holder.BaseHolder
import com.example.qiboxia.myapplication.network.data.OrderListItem

public class OrderHolder(cxt: Context, parent: ViewGroup?) : BaseHolder<OrderListItem>(R.layout.list_item_order, cxt, parent) {

    private val titleText = itemView.findViewById<TextView>(R.id.title)
    private val contentText = itemView.findViewById<TextView>(R.id.content)

    init {
        titleText.setOnClickListener { _ ->
            data?.let {
                ToastManager.show(itemView.context, it.orderId)
            }
        }
    }

    override fun onItemClick(t: OrderListItem?, position: Int) {

    }

    override fun bindData(t: OrderListItem) {
        super.bindData(t)
        titleText.text = t.orderId
        contentText.text = t.time
    }
}
