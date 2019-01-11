/**
 * 文 件 名: BaseActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:37
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import kotlinx.android.synthetic.main.toolbar.*

/**
 * 文 件 名: BaseActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:37
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var mToolbar  : Toolbar ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        registerView()
    }

    protected abstract fun getLayoutRes() : Int
    protected abstract fun getActTitle() : String

    protected open fun registerView(){
        setupToolbar()
    }



    protected open fun setupToolbar(){
        mToolbar = toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getActTitle()
    }





}
