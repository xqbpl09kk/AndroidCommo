/**
 * 文 件 名: SplashActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 17:29
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.launcher.activity;

import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity

public class SplashActivity :BaseActivity(){
    override fun getLayoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun getActTitle(): String {
        return ""
    }
}
