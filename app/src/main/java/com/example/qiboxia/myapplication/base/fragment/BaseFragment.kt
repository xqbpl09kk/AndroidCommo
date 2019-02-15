/**
 * 文 件 名: BaseFragment
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 16:21
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.base.fragment;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qiboxia.myapplication.application.SApplication

/**
 * 文 件 名: BaseFragment
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/8 16:21
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SApplication.getInstance().addFragment(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        SApplication.getInstance().removeFragment(this)
    }
}
