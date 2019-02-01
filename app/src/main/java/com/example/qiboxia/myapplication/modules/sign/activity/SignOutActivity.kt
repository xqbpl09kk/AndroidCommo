/**
 * 文 件 名: SignOutActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 14:38
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.sign.activity;
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity

/**
 * 文 件 名: SignOutActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 14:38
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
public class SignOutActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_sign_out
    }

    override fun getActTitle(): String {
        return getString(R.string.sign_out)
    }
}
