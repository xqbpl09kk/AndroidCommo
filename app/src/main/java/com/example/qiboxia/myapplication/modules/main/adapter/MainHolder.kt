/**
 * 文 件 名: MainHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 14:17
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.main.adapter;

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.adapter.holder.BaseHolder
import com.example.common.app.ToastManager

/**
 * 文 件 名: MainHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 14:17
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class MainHolder(context: Context , parent: ViewGroup)
    : BaseHolder<String>(R.layout.list_item_main, context, parent) {

    private val text :TextView = itemView.findViewById(R.id.text)

    override fun onItemClick(t: String?, position: Int) {
        ToastManager.show(context , t)
    }

    override fun bindData(t: String) {
        super.bindData(t)
        text.text = t
    }

}
