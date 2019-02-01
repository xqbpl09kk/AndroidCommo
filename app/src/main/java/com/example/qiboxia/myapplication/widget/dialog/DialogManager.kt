package com.example.qiboxia.myapplication.widget.dialog

import android.view.View
import com.example.qiboxia.myapplication.application.SApplication

/**
 * 文 件 名: DialogManager
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/25 17:51
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object DialogManager : IDialog {

    private val context = SApplication.getInstance()

    override fun showLoadingDialog(msg: String) {

    }

    override fun showBottomDialog(contentView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCustmerDialog(contentView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTopDialog(contentView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCommoneDialog(title: String, content: String, positiveBtn: String, negativeBtn: String, positiveListener: View.OnClickListener, negativeListener: View.OnClickListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}