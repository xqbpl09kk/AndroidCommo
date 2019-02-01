package com.example.qiboxia.myapplication.utils

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * 文 件 名: RxUtils
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/1 15:16
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object RxUtils{

    private val TAG = "RxUtils"
    private val disposables  : HashMap<String , HashSet<Disposable>> = hashMapOf()


    /**
     * just使用
     */
    fun just(tag : String = "Main"){
        Observable.just("title")
                .subscribe({
                    Log.e(TAG , "just $it")
                } ,{
                    Log.e(TAG , "just throws ${it.message}")
                } , {

                } , {

                }).add(tag )
    }


    /**
     * 创建observable
     */
    fun createObservable(tag : String = "Main"){
        Observable.create(
                ObservableOnSubscribe<Int> {
                    emitter -> emitter.onNext(123) })
                .subscribe {
                    Log.e(TAG , "$it")
                }.add(tag)
    }

    fun createObserver(){
        val observer = object : Observer<String> {
            override fun onComplete() {
                Log.e(TAG , "on complete")
            }
            override fun onSubscribe(d: Disposable) {
                Log.e(TAG , "on subscribe ${d.isDisposed}")
            }
            override fun onNext(t: String) {
                Log.e(TAG , "on next $t")
            }
            override fun onError(e: Throwable) {
                Log.e(TAG , "on error ${e.message}")
            }
        }
        Observable.just("123" , "!2322" , "3213").subscribe(observer)
    }



    private inline fun Disposable.add(tag:String?){
        addTo(tag , this)
    }



    fun addTo(tag : String? , disposable: Disposable){
        val set = disposables[tag]
        set?.let {
            it.add(disposable)
        } ?: HashSet<Disposable>().let {
            it.add(disposable)
            disposables.put(tag?:"" , it)
        }
    }

    fun cancel(tag :String ?= "Main" ){
        val set = disposables[tag]
        set?.let {
            for(item in set){
                item.dispose()
            }
            disposables.remove(tag)
        }
    }
}