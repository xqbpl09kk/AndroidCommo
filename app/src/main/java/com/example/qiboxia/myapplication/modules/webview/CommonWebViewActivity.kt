/**
 * 文 件 名: CommonWebViewActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/24 11:23
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.webview;
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity

public class CommonWebViewActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_web_view
    }

    override fun getActTitle(): String {
        return getString(R.string.web_view_title)
    }
}
