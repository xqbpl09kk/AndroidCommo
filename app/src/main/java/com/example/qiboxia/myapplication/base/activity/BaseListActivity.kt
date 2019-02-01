/**
 * 文 件 名: BaseListActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 17:06
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity;

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.adapter.BaseAdapter
import com.example.qiboxia.myapplication.base.adapter.holder.BaseHolder

/**
 * 文 件 名: BaseListActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 17:06
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class BaseListActivity<T  ,H : BaseHolder<T>,  A : BaseAdapter<T , H>>: ServiceBindActivity<ArrayList<T>>(){

    private var pageNum : Int = 1
    private var recyclerView : RecyclerView ?= null
    private var adapter :A ?= null

    override fun registerView() {
        super.registerView()
        recyclerView = findViewById(R.id.refresh_layout)
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(true) {
                    pageNum ++
                    networkStep()
                }
            }
        })
        recyclerView?.adapter = initAdapter()
        recyclerView?.layoutManager = LinearLayoutManager(appContext)
        val refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refresh_layout)
        refreshLayout.setOnRefreshListener {
            pageNum = 1
            networkStep()
        }
    }

    override fun onDataFetch(t : ArrayList<T>){
        if(pageNum == 1){
            super.onDataFetch(t)
            adapter?.updateData(t)
        }else{
            adapter?.addData(t)
        }
    }


    abstract fun initAdapter() : A

}
