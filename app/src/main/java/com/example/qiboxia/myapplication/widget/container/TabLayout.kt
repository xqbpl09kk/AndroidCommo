package com.example.qiboxia.myapplication.widget.container

import android.content.Context
import android.support.annotation.IntDef
import android.support.annotation.RestrictTo
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Suppress("DEPRECATED_JAVA_ANNOTATION")
/**
 * 文 件 名: TabLayout
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/15 15:52
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class TabLayout : HorizontalScrollView {

    companion object {
        const val MODE_SCROLLABLE = 1
        const val MODE_FIXED = 2

        @IntDef(value = [MODE_SCROLLABLE, MODE_FIXED])
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
        annotation class Mode
    }

    @Mode
    private var mMode: Int = MODE_SCROLLABLE
    private var mContext: Context? = null


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    init {

    }

    private fun init(context: Context?) {
        mContext = context
    }



    fun setTabMode(@Mode mode: Int) {
        if (mode == mMode) return
        mMode = mode
        init(mContext)
    }

    fun attachViewPager(viewPager : ViewPager){
        val count = viewPager.childCount
        val adapter = viewPager.adapter
        if(adapter is FragmentPagerAdapter){
            adapter.getItem(0)
        }
    }

    fun initTabItem(position : Int , text : String){

    }


    class TabItem : LinearLayout{
        constructor(context: Context?) : this(context , null)
        constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs , 0 )
        constructor(context: Context?
                    , attrs: AttributeSet?
                    , defStyleAttr: Int)
                : super(context, attrs, defStyleAttr){
            init()
        }

        init {

        }

        fun init(){

        }
    }

}