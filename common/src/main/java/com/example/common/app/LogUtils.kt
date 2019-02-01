package com.example.common.app

import android.util.Log

/**
 * 文 件 名: LogUtils
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/25 18:10
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object LogUtils {
    private val LOG_KEY = "pl09kk"

    fun e(msg: String, tag: String? = null) {
        Log.e(LOG_KEY.plus(tag), msg)
    }

    fun w(msg: String, tag: String? = null) {
        Log.w(LOG_KEY.plus(tag), msg)
    }

    fun d(msg: String, tag: String? = null) {
        Log.d(LOG_KEY.plus(tag), msg)
    }

    fun v(msg: String, tag: String? = null) {
        Log.v(LOG_KEY.plus(tag), msg)
    }

    fun i(msg: String, tag: String? = null) {
        Log.i(LOG_KEY.plus(tag), msg)
    }
}