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
abstract class BaseAdapter<T , H :BaseHolder<T>> (protected  val context : Context) :RecyclerView.Adapter<H>() {

    protected val data : ArrayList<T> = arrayListOf()


    override fun getItemCount(): Int {
        return  data.size
    }


    override fun onBindViewHolder(holder: H, position: Int) {
        holder.bindData(data[position])
    }


    fun updateData(items : ArrayList<T>?){
        data.clear()
        notifyDataSetChanged()
        items?.let { addData(it) }
    }

    fun addData(items : ArrayList<T>?){
        items?.let {
            val startPosition = data.size
            data.addAll(it)
            notifyItemRangeInserted(startPosition , it.size)
        }
    }

    fun removeItem(position : Int){
        if(position >= data.size ) return
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addItem(item : T){
        data.add(item)
        notifyItemInserted(data.indexOf(item))
    }


}
