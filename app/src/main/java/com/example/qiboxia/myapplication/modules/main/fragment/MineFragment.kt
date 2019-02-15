/**
 * 文 件 名: MineFragment
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/23 17:34
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.modules.main.fragment;

import com.example.qiboxia.myapplication.R
import com.example.qiboxia.myapplication.base.fragment.BaseFragment

public class MineFragment :BaseFragment(){
    override fun getTitle(): String {
        return getString(R.string.mine)
    }
}
