/**
 * 文 件 名: Combination
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/15 17:16
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
package com.example.qiboxia.myapplication.utils.rxjava;

import android.util.Log
import com.example.qiboxia.myapplication.utils.add
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit


object Combination {
    val TAG = "Combination"
    /**
     * concat ，最多发送4个Observable事件 ，
     */
    fun concat() {
        Observable.concat(
                Observable.just(1, 2, 3, 4)
                , Observable.just(5, 6, 7, 8)

        ).subscribe({
            Log.e("Main", "concat result is $it")
        }, {

        }).add(TAG)
    }

    /**
     * concatArray : 功能和concat一样，concat的数量可以大于四个
     */
    fun concatArray() {
        Observable.concatArray(
                Observable.just(1)
                , Observable.error(IllegalArgumentException("hahahah"))
                , Observable.fromIterable(arrayListOf())
                , Observable.fromArray(arrayOf(true, false))
                , Observable.just("google")
        ).subscribe({
            Log.e(TAG, "onNext $it")
        }, {
            Log.e(TAG, "onError is ${it.message}")
        }).add(TAG)
    }

    /**
     * merge : 功能和concat一样，concat是串行有序的， merge是并行无序的
     */
    fun merge() {
        Observable.merge(
                Observable.just(1, 2, 3)
                , Observable.just("justice", 5, 6)
        ).subscribe({
            if (it is Int) {

            } else if (it is String) {

            }
        }, {

        }).add(TAG)
    }


    /**
     * concatArrayDelayError
     * mergeArrayDelayError
     * 在concatArray 和mergeArray方法中发生error事件， 会停止发送事件，
     * concatArrayDelayError 会延迟error事件到最后处理
     */
    fun concatArrayDelayError() {
        Observable.concatArrayDelayError(
                Observable.just(1)
                , Observable.error(IllegalArgumentException("hahahah"))
                , Observable.fromIterable(arrayListOf())
                , Observable.fromArray(arrayOf(true, false))
                , Observable.just("google")
        ).subscribe({
            Log.e(TAG, "DELAY onNext $it")
        }, {
            Log.e(TAG, "DELAY onError is ${it.message}")
        }).add(TAG)
    }


    /**
     * zip : 将多个发送源的事件一一对应，最终结合发送的事件是多个源中事件最少的一个
     */
    fun zip() {
        Observable.zip(
                Observable.intervalRange(1, 10, 1, 3, TimeUnit.SECONDS)
                , Observable.intervalRange(2, 8, 1, 1, TimeUnit.SECONDS)
                , BiFunction<Long, Long, Long> { t1, t2 -> t1 * t1 + t2 * t2 }
        ).subscribe({
            Log.e(TAG , "zip result is $it")
        }, {

        }).add(TAG)
    }


    /**
     * reduce：将被传递的每个observable传递给biFunction方法计算，计算结果发送给监听者
     */
    fun reduce(){
        Observable.just(1,2,3,4,5)
                .reduce { t1, t2 -> t1 + t2 }.subscribe({
                    Log.e(TAG , "reduce result is $it")
                } ,{

                }).add(TAG)
    }
}
