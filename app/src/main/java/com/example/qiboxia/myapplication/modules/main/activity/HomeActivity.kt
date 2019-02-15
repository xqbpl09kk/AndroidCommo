package com.example.qiboxia.myapplication.modules.main.activity

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.application.SApplication
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.base.activity.ServiceBindActivity
import com.example.qiboxia.myapplication.base.listener.LoginStatusListener
import com.example.qiboxia.myapplication.modules.main.adapter.MainAdapter
import com.example.qiboxia.myapplication.modules.webview.CommonWebViewActivity
import com.example.qiboxia.myapplication.network.data.User
import com.example.qiboxia.myapplication.utils.DialogUtils
import com.example.qiboxia.myapplication.utils.RxUtils
import com.example.qiboxia.myapplication.utils.rxjava.Conversion
import com.example.qiboxia.myapplication.utils.rxjava.Creation
import com.example.qiboxia.myapplication.utils.rxjava.add
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : ServiceBindActivity<Any>() {
    override fun networkStep() {

    }

    override fun onLogin(user: User) {
        Log.e("MainActivity"  , "Log in ")
    }

    override fun onLogout() {
        Log.e("MainActivity"  , "Log out ")
    }

    override fun getActTitle(): String {
        return "首页"
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    private var adapter: MainAdapter? = null

    override fun registerView() {
        super.registerView()
        adapter = MainAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
//        DialogUtils.createOptionalDialog("1" , DialogInterface.OnClickListener { _, _ -> })
//        RxUtils.just()
//        RxUtils.createObservable()
//        RxUtils.createObserver()
//        Creation.intervalRange()
//        Conversion.map()
//        appContext.removeActivity(this)
//        startActivity(Intent(this ,CommonWebViewActivity::class.java))
        Conversion.buffer()
    }


    override fun onResume() {
        super.onResume()
        test()
    }
    override fun onDestroy() {
        super.onDestroy()
        RxUtils.cancel()
//        Creation.cancel()
    }

    private fun showDialog(){

    }

    private fun test(){
        val activities = SApplication.getInstance().getActivities()
        Observable.fromIterable(activities)
                .filter { it is LoginStatusListener }
                .map { it as LoginStatusListener }
                .subscribe { it.onLogout() }
                .add("Login")
        val fragments = SApplication.getInstance().getFragments()
        Observable.fromIterable(fragments)
                .filter { it is LoginStatusListener }
                .map { it as LoginStatusListener }
                .subscribe{it.onLogout()}
                .add("Login")
    }



}
