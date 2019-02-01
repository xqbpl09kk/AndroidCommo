package com.example.qiboxia.myapplication.base.adapter.holder

import android.content.Context
import android.widget.TextView
import android.widget.Toast

/**
 * 文 件 名: MoreHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 18:08
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class MoreHolder(context: Context) : BaseHolder<Any>(TextView(context)) {
    override fun onItemClick(t: Any?, position: Int) {
        Toast.makeText(itemView.context, "加载更多" , Toast.LENGTH_SHORT).show()
    }

    init {
        itemView.setPadding(10 ,10 ,10 ,10 )
        (itemView as TextView).text = "查看更多"
    }

}