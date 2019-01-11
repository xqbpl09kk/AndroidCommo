package com.example.common.app

import android.content.Context

/**
 * 文 件 名: AppUtils
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:46
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object AppUtils{

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue px
     * @return sp
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue sp
     * @return px
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}