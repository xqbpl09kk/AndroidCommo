@file:Suppress("NOTHING_TO_INLINE")

package com.example.qiboxia.myapplication.utils

import io.reactivex.disposables.Disposable

/**
 * 文 件 名: Convert
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/13 19:01
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */


inline fun Disposable.add(tag: String) {
    addTo(tag, this)
}


private val disposables: HashMap<String, HashSet<Disposable>> = hashMapOf()

fun addTo(tag :String = "Main" , disposable : Disposable){
    val set = disposables[tag]
    set?.let {
        it.add(disposable)
    } ?: HashSet<Disposable>().let {
        it.add(disposable)
        disposables.put(tag , it)
    }
}