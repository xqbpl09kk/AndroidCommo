/**
 * 文 件 名: CommonWebViewActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/24 11:23
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.webview;
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.modules.main.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_web_view.*

public class CommonWebViewActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_web_view
    }

    override fun getActTitle(): String {
        return getString(R.string.web_view_title)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun registerView() {
        super.registerView()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.baidu.com")
        val chromeClient =object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if(newProgress == 100){
                    progress_bar.hide()
                }else{
                    progress_bar.show()
                    progress_bar.progress = newProgress
                }
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                supportActionBar?.title = title
            }

            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
                super.onReceivedIcon(view, icon)
            }

        }
        webView.webChromeClient = chromeClient
    }

    override fun onBackPressed() {
         if(webView.canGoBack()){
             webView.goBack()
         }else{
             super.onBackPressed()
         }
    }
}
