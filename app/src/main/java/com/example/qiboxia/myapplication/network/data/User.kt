package com.example.qiboxia.myapplication.network.data

/**
 * 文 件 名: User
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 17:43
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */

open class User{
    var name : String =""
    var id :String = ""
    var avatar :String =""
}

class OAuthUser : User(){
    var token :String = ""
}