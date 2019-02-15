package com.example.qiboxia.myapplication.modules.order.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.application.SApplication
import com.example.qiboxia.myapplication.base.fragment.BaseFragment
import com.example.qiboxia.myapplication.modules.order.adapter.OrderListAdapter
import kotlinx.android.synthetic.main.common_refresh_list.*

/**
 * 文 件 名: OrderListFragment
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/15 14:49
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class OrderListFragment : BaseFragment(){
    companion object {
        var index : Int = 0
    }
    override fun getTitle(): String {
        index ++
        return "订单 $index"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.common_refresh_list , container , false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        val adapter = OrderListAdapter(SApplication.getInstance())
        recycler_view.adapter = adapter


    }

}