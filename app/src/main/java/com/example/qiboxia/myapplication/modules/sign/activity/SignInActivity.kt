/**
 * 文 件 名: SignInActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 14:36
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.sign.activity;

import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.ServiceBindActivity

/**
 * 文 件 名: SignInActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 14:36
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
public class SignInActivity :ServiceBindActivity<Any>(){
    override fun networkStep() {
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_sign_in
    }

    override fun getActTitle(): String {
        return getString(R.string.sign_in)
    }
}
