/**
 * 文 件 名: BaseAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:53
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.adapter;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.qiboxia.myapplication.base.adapter.holder.BaseHolder

/**
 * 文 件 名: BaseAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:53
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class BaseAdapter<T> (protected  val context : Context)
    :RecyclerView.Adapter<BaseHolder<T>>() {

    protected val data : ArrayList<T> = arrayListOf()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bindData(data[position])
    }


    fun updateData(items : ArrayList<T>){
        data.clear()
        notifyDataSetChanged()
        addData(items)
    }

    fun removeItem(position : Int){
        if(position >= data.size ) return
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addData(items : ArrayList<T>){
        val startPosition = data.size
        data.addAll(items)
        notifyItemRangeInserted(startPosition , items.size)
    }

    fun addItem(item : T){
        data.add(item)
        notifyItemInserted(data.indexOf(item))
    }
}
