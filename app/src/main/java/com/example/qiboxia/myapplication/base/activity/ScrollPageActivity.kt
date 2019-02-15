/**
 * 文 件 名: ScrollPageActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/15 14:22
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.fragment.BaseFragment
import kotlinx.android.synthetic.main.activity_scroll_page.*

abstract class ScrollPageActivity : BaseActivity(){

    override fun getLayoutRes(): Int {
        return R.layout.activity_scroll_page
    }



    override fun registerView() {
        super.registerView()
        view_pager.adapter = FragmentAdapter(getFragmentList() , supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

    abstract fun getFragmentList() : ArrayList<out BaseFragment>

    companion object {
        class FragmentAdapter(val fragments : ArrayList<out BaseFragment>
                              , fm : FragmentManager)
            : FragmentPagerAdapter(fm){
            override fun getItem(position: Int): BaseFragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return fragments[position].getTitle()
            }

        }
    }

}
