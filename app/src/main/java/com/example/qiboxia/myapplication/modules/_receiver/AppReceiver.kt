package com.example.qiboxia.myapplication.modules._receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AppReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.e("AppReceiver" , "intent action is ${intent.action}")
    }
}
