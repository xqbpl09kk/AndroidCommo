package com.example.qiboxia.myapplication.modules.main.activity

import android.app.ActivityManager
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.common.platform.StringUtils
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.modules.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashSet

class MainActivity : BaseActivity() {
    override fun getActTitle(): String {
        return "首页"
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }


    private var adapter :MainAdapter ?= null

    override fun registerView() {
        super.registerView()
        adapter =  MainAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter?.addItem("dsadjkldjsa")
    }

    override fun setupToolbar() {
        super.setupToolbar()
        mToolbar
    }


    private fun getAppList(){
        val packs = packageManager.getInstalledPackages(0)
        for (pack in packs){
            Log.e("MainActivity" , "flag = 0 ${pack.packageName}")
        }
    }

    private fun getProcessList(){
        val mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val list =  mActivityManager.getRunningServices(1000)
        for (item in list){
            Log.e("MainActivity", " pack : ${item.clientPackage}" +
                    " ,pid =${item.pid}  , packageName ${item.service.packageName}" +
                    "cls :${item.service.className} , sCls ${item.service.shortClassName}")
        }
    }


    private fun getApps(){
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //noinspection ConstantConditions
        val info = am.runningAppProcesses
        val names = HashSet<String>()
        if (info == null || info.size == 0) return
        for (aInfo in info) {
            Log.e("MainActivity" ,  aInfo.processName)
        }

    }


}
