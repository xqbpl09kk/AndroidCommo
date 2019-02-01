package com.example.qiboxia.myapplication.modules.main.activity

import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.modules.main.adapter.MainAdapter
import com.example.qiboxia.myapplication.utils.DialogUtils
import com.example.qiboxia.myapplication.utils.RxUtils
import com.example.qiboxia.myapplication.utils.rxjava.Creation
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity() {
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
        Creation.defer()
    }

    override fun onDestroy() {
        super.onDestroy()
        RxUtils.cancel()
    }

    private fun showDialog(){

    }

}
