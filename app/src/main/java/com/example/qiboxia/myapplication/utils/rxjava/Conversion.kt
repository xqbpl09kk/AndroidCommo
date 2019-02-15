package com.example.qiboxia.myapplication.utils.rxjava

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function

/**
 * 文 件 名: Conversion
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/13 18:58
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
object Conversion {

    private val TAG = "CONVERSION"

    /**
     * MAP ：可以将被观察的数据转换成其他类型的数据
     */
    public fun map() {
        Observable.just(1, 2, 3)
                .map {
                    it.plus(20)
                }.subscribe({
                    System.out.println("result is $it")
                }, {

                }, {

                }, {

                }).add("conversion")
    }




    data class Person(var name: String
                      , var score: List<Plan>)

    data class Plan(var ar1: ArrayList<String>)

    /**
     * flatMap ，和map类似，但是可以重新发送新的可监听事件 ，没有顺序
     */
    fun flatMap() {
           Observable.fromIterable(getData())
                .map(object : Function<Person, List<Plan>> {
                    override fun apply(t: Person): List<Plan> {
                        return t.score
                    }

                })
                .map(object : Function<List<Plan>, String> {
                    override fun apply(t: List<Plan>): String {
                        return t[1].ar1[0]
                    }

                })
                .subscribe({

                }, {

                })
                .add(TAG)

        //示例 ： map ， 无法多级发出observable事件
        Observable.fromIterable(getData())
                .flatMap(object : Function<Person, ObservableSource<Plan>> {
                    override fun apply(t: Person): ObservableSource<Plan> {
                        return Observable.fromIterable(t.score)
                    }

                })
                .flatMap(object : Function<Plan, ObservableSource<String>> {
                    override fun apply(t: Plan): ObservableSource<String> {
                        return Observable.fromIterable(t.ar1)
                    }

                })
                .subscribe({

                }, {

                })
                .add(TAG)
        //
        Observable.fromIterable(getData())
                .flatMap { t -> Observable.fromIterable(t.score) }
                .flatMap { t -> Observable.fromIterable(t.ar1) }
                .map {
                    it.plus("123")
                }
                .flatMap { t -> Observable.just(t.plus("zaijianlixiang")) }
                .subscribe({
                    Log.e("Main", "flatmap result is $it")
                    System.out.println("flat map result is $it")
                }, {})
                .add(TAG)


    }

    /**
     * concat map : 有序的flatMap
     */
    fun concatMap(){
        Observable.fromIterable(getData())
                .concatMap (object : Function<Person , ObservableSource<Plan>> {
                    override fun apply(t: Person): ObservableSource<Plan> {
                        return Observable.fromIterable(t.score)
                    }

                }).subscribe({

                } ,{

                }).add(TAG)
    }

    /**
     * buffer : 从需要发送的事件中获取一定数量的事件， 并且将这些事件放到缓存中一并发出
     */
    fun buffer(){
        Observable.fromIterable(getData()).buffer(2  , 1)
                .subscribe({
                    Log.e("Main" , "msg is $it")
                } ,{

                }).add(TAG)
//        Observable.just(1,2,3,4).buffer(2 , 1).subscribe({
//            Log.e("Main" , "msg is $it")
//        } , {
//
//        }).add(TAG)
    }


    fun getData() : ArrayList<Person>{
        val personList = arrayListOf<Person>()
        personList.add(Person("nam1", arrayListOf(Plan(arrayListOf("hao")), Plan(arrayListOf("hao")))))
        personList.add(Person("nam2", arrayListOf(Plan(arrayListOf("liang")), Plan(arrayListOf("liang")))))
        personList.add(Person("nam3", arrayListOf(Plan(arrayListOf("cha")), Plan(arrayListOf("cha")))))
        return personList
    }
}