@file:Suppress("NOTHING_TO_INLINE")

package com.example.qiboxia.myapplication.utils.rxjava

import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.FutureTask
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

/**
 * 文 件 名: Creation
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/1 16:46
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object Creation {
    private val TAG = "RxUtils"



    /**
     * just使用
     */
    fun just(tag: String = "Main") {
        Observable.just("title")
                .subscribe({
                    Log.e(TAG, "just $it")
                }, {
                    Log.e(TAG, "just throws ${it.message}")
                }, {

                }, {

                }).add(tag)
    }


    /**
     * fromArray
     */
    fun from(tag: String = "Main") {
        Observable.fromArray(1, 2, 23).subscribe({

        }, {

        }).add(tag)
        val arrayList = arrayListOf<String>("", "")
        Observable.fromArray(arrayList).subscribe({

        }, {

        }, {

        }).add(tag)
    }

    /**
     * from callable
     */
    fun fromCallable(tag: String = "Main") {
        val observable = Observable.fromCallable { 123 }
        observable.subscribe({

        }, {

        }).add(tag)
    }


    /**
     * from future ： 拓展的callable
     */
    fun fromFuture(tag: String = "Main") {

        val future = object : Future<String> {
            override fun isDone(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun get(): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun get(timeout: Long, unit: TimeUnit?): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun cancel(mayInterruptIfRunning: Boolean): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isCancelled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        val futureTask = FutureTask(Callable<Int> { 123 })
        Observable.fromFuture(futureTask) .subscribe({

        }, {

        }, {

        }, {
            Log.e(TAG, "onSubscribe , 111")
        }).add(tag)
    }

    /**
     * from iterable ：从iterable创建
     */
    fun fromIterable(tag :String = "Main"){
        Observable.fromIterable(arrayListOf<String>()).subscribe({

        } ,{

        },{

        },{

        }).add(tag)
    }


    /**
     *defer ： 延缓创建observable
     */
    fun defer(tag :String = "Main"){
        val observable = Observable.defer { Observable.just(123) }
        val observable2 = Observable.just("dsad")
        Log.e(TAG , "before subscribe , observable is $observable")
        Log.e(TAG , "2 is $observable2")
        observable.subscribe({

        } , {

        }).add(tag)
    }

    /**
     * timer ： 定时发送值为0的
     */
    fun timer(tag :String = "Main"){
        val observable = Observable.timer(5 , TimeUnit.SECONDS)
        observable.subscribe({
            Log.e(TAG  , "on timer $it" )
        } , {

        }).add(tag)
    }

    /**
     * interval ： 每隔一段时间发送一个事件，返回的值从0不断增长
     */
    fun interval(tag :String = "Main") {
        val observable = Observable.interval(2 , TimeUnit.SECONDS)
        observable.subscribe({
            Log.e(TAG , "interval  $it")
        } ,{

        }).add(tag)
    }

    /**
     * intervalRange() :在interval基础上指定开始值和范围
     */
    fun intervalRange(tag : String = "Main"){
        val observable = Observable.intervalRange(11 , 20 , 0 , 2 , TimeUnit.SECONDS)
        observable.subscribe({
            Log.e(TAG , "interval range $it")
        } ,{

        }).add(tag)
    }

    /**
     * range
     */
    fun range(tag: String = "Main"){
        val observable = Observable.range(1 , 20)
        observable.subscribe({
            Log.e(TAG , "interval range $it")
        } ,{

        }).add(tag)
    }

    /**
     * 创建observable
     */
    fun createObservable(tag: String = "Main") {
        Observable.create(
                ObservableOnSubscribe<Int> { emitter -> emitter.onNext(123) })
                .subscribe {
                    Log.e(TAG, "$it")
                }.add(tag)
    }

    fun createObserver() {
        val observer = object : Observer<String> {
            override fun onComplete() {
                Log.e(TAG, "on complete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.e(TAG, "on subscribe ${d.isDisposed}")
            }

            override fun onNext(t: String) {
                Log.e(TAG, "on next $t")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "on error ${e.message}")
            }
        }
        Observable.just("123", "!2322", "3213").subscribe(observer)
    }


//    private inline fun Disposable.add(tag: String?) {
//        addTo(tag, this)
//    }


//     fun addTo(tag: String?, disposable: Disposable) {
//        val set = disposables[tag]
//        set?.let {
//            it.add(disposable)
//        } ?: HashSet<Disposable>().let {
//            it.add(disposable)
//            disposables.put(tag ?: "", it)
//        }
//    }
//
//    fun cancel(tag: String? = "Main") {
//        val set = disposables[tag]
//        set?.let {
//            for (item in set) {
//                item.dispose()
//            }
//            disposables.remove(tag)
//        }
//    }
}