/**
 * 文 件 名: PagedBaseAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 18:20
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.adapter;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.qiboxia.myapplication.base.adapter.holder.BaseHolder
import com.example.qiboxia.myapplication.base.adapter.holder.MoreHolder

abstract class PagedBaseAdapter<T , H :BaseHolder<T>>(context: Context) :BaseAdapter<T , H>(context){

    companion object {
        const val TYPE_MORE = 1001
    }

    private var moreData : Boolean = false

    override fun getItemCount(): Int {
        return if(moreData) super.getItemCount() else super.getItemCount()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {
//        if(viewType == TYPE_MORE){
//            return MoreHolder(context)
//        }
        return super.createViewHolder(parent , viewType)
    }



    override fun getItemViewType(position: Int): Int {
        if(position == data.size){
            return TYPE_MORE
        }
        return super.getItemViewType(position)
    }


    fun setMoreDataEnable(enabled : Boolean){
        if(moreData.xor(enabled)){
            moreData = enabled
            notifyDataSetChanged()
        }
    }
}


