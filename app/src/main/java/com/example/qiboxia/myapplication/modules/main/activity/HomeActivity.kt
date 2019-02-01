package com.example.qiboxia.myapplication.modules.main.activity

import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.activity.BaseActivity
import com.example.qiboxia.myapplication.modules.main.adapter.MainAdapter
import com.example.qiboxia.myapplication.utils.DialogUtils
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
        adapter?.addItem("dsadjkldjsa")
        adapter?.addItem("dsadjkldjsa")
        adapter?.addItem("dsadjkldjsa")
        adapter?.addItem("dsadjkldjsa")
        adapter?.addItem("dsadjkldjsa")

//        val intent = Intent(this@HomeActivity , JobService::class.java)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(intent)
//        }else{
//            startService(intent)
//        }
        DialogUtils.createOptionalDialog("hahahhaahaha" , object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {

            }
        })

    }


    private fun showDialog(){

    }

}
