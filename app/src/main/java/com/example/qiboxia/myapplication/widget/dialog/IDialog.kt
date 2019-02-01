package com.example.qiboxia.myapplication.widget.dialog

import android.view.View

/**
 * 文 件 名: IDialog
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/25 18:02
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
interface IDialog {
    fun showLoadingDialog(msg : String)

    fun showBottomDialog(contentView : View)

    fun showCustmerDialog(contentView : View)

    fun showTopDialog(contentView: View)

    fun showCommoneDialog(
            title :String ,
            content : String ,
            positiveBtn : String ,
            negativeBtn :String ,
            positiveListener : View.OnClickListener ,
            negativeListener : View.OnClickListener
    )
}