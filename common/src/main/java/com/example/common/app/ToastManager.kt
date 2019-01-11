package com.example.common.app

import android.content.Context
import android.widget.Toast

/**
 * 文 件 名: ToastManager
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 15:13
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object ToastManager {

    fun show(context : Context , content: String?) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }
}