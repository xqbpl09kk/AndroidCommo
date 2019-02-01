/**
 * 文 件 名: BaseHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:56
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.adapter.holder;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 文 件 名: BaseHolder
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:56
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class BaseHolder<T> : RecyclerView.ViewHolder, AdapterItemListener<T> {
    constructor(view : View) :super(view)
    constructor(layout: Int, cxt: Context, parent: ViewGroup?) : super(LayoutInflater.from(cxt).inflate(layout, parent, false))

    protected var data  :T ? =null

    init { itemView.setOnClickListener { _ -> data?.let { onItemClick(it , adapterPosition) } } }

    /*** 绑定数据
     *  @param t : 绑定的数据
     */
    open fun bindData(t : T){ data = t }

    /**
     * 当改条数据变化的时候
     */
    protected fun onItemChanged(){ (itemView.parent as? RecyclerView)?.adapter?.notifyItemChanged(adapterPosition) }

}
