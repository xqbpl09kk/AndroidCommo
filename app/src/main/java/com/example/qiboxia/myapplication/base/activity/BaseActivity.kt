/**
 * 文 件 名: BaseActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 13:37
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity;

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import android.view.MenuItem
import com.example.common.app.ToastManager
import com.example.qiboxia.myapplication.BuildConfig
import com.example.qiboxia.myapplication.application.SApplication
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        var appContext = SApplication.getInstance()
    }

    protected var mToolbar  : Toolbar ? =null

    protected lateinit var lifecycleRegistry : LifecycleRegistry

    protected val uiHandler by lazy {  Handler()  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        SApplication.getInstance().addActivity(this)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        try{
            registerView()
        }catch (throwable : Throwable){
            throwable.printStackTrace()
            if(BuildConfig.DEBUG){
                throw throwable
            }else{
                ToastManager.show(this , "crash on register view ${this@BaseActivity.localClassName} , ${this@BaseActivity}")
            }
        }
    }


    override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }


    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
        SApplication.getInstance().removeActivity(this)
        uiHandler.removeCallbacks(null)
    }

    override fun getLifecycle(): Lifecycle{
        return  lifecycleRegistry
    }

    protected abstract fun getLayoutRes() : Int
    protected abstract fun getActTitle() : String
    protected fun beforeCreate() {
        //do nothing
    }

    protected open fun registerView(){
        setupToolbar()
    }



    protected open fun setupToolbar(){
        mToolbar = toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getActTitle()

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }




}
