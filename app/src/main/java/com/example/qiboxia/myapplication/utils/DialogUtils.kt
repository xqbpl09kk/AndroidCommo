/**
 * 文 件 名: DialogUtils
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/31 16:53
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.utils

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import com.example.qiboxia.myapplication.application.SApplication
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.R

object DialogUtils {

    fun createOptionalDialog(message: String
                             , positiveListener: DialogInterface.OnClickListener
                             , title: String = "标题"
                             , positiveBtn: String = "确认"
                             , negativeBtn: String = "取消"
                             , activity: BaseActivity? = SApplication.getInstance().currentActivity()
                             , negativeListener: DialogInterface.OnClickListener? = null
                             , dismissListener: DialogInterface.OnDismissListener? = null) {
        val dialog = AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveBtn, positiveListener)
                .setNegativeButton(negativeBtn, negativeListener)
                .setIcon(R.mipmap.ic_launcher)
                .create()
        dialog.setOnDismissListener(dismissListener)
        dialog.show()
    }


    fun createCustomerDialog(registedView: View) {

    }

    fun createPromptDialog() {

    }

}
