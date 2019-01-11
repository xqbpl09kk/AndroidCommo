/**
 * 文 件 名: MainAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:47
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.main.adapter;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.qiboxia.myapplication.base.adapter.BaseAdapter

/**
 * 文 件 名: MainAdapter
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:47
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class MainAdapter(context: Context) : BaseAdapter<String>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MainHolder{
        return MainHolder(context ,parent)
    }
}
