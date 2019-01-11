/**
 * 文 件 名: SApplication
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 15:13
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base;

import android.app.Application

/**
 * 文 件 名: SApplication
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 15:13
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
public class SApplication : Application() {

    companion object {

        private lateinit var instance : SApplication

        fun getInstance() :SApplication{
            return instance
        }
    }



    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
