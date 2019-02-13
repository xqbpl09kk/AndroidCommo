package com.example.qiboxia.myapplication.third_party

/**
 * 文 件 名: Events
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/1/21 14:27
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：Event bus的事件
 */

data class SignInEvent(var event: UserEvent) {
    enum class UserEvent { USER_LOGIN, USER_LOGOUT, INVALIDATE }
}

data class OrderEvent(var event: OrderEvents) {
    enum class OrderEvents { Create, Paid, Cancel, Invalidate }
}

data class ServiceEvent(var code : Int , val msg :String)

data class ActivityEvent(var activityCode : Int , val msg : String)
