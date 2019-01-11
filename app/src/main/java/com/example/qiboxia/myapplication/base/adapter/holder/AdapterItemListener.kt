package com.example.qiboxia.myapplication.base.adapter.holder

/**
 * 文 件 名: AdapterItemListener
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 14:12
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
interface AdapterItemListener<T> {

    fun onItemClick(t :T? , position : Int)

}