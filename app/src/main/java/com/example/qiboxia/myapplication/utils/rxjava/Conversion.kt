package com.example.qiboxia.myapplication.utils.rxjava

import android.util.Log
import com.example.qiboxia.myapplication.utils.add
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.BiFunction
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


    fun filter(){
        Observable.just(1,2,3,4,5)
                .filter { it % 2 == 0 }
                .map { it * it }
                .subscribe({
                    Log.e("Main" , "filter result is $it")
                } ,{

                }).add(TAG)
    }

    /**
     * groupBy : 将发送的数据进行分组， 每个分组都会返回一个被观察者
     */
    fun groupBy(){
//        Observable.just(1,2,3,4,5)
//                .groupBy (object : Function<Int , Int> {
//                    override fun apply(t: Int): Int {
//                        return t %3
//                    }
//                }).subscribe({
//                    Log.e(TAG , "group buy result is $it")
//                } , {
//
//                }).add(TAG)
        Observable.just(1,2,3,4,5)
                .groupBy (object : Function<Int , Int> {
                    override fun apply(t: Int): Int {
                        return t %3
                    }
                }).filter {
                    it.key?.rem(3) ?: 0 == 0
                }.subscribe({groupedObserver ->
                    groupedObserver.subscribe({
                        Log.e(TAG , "groupedObserver is ${groupedObserver.key} ,group buy result is $it")
                    } ,{

                    }).add(TAG)
                } ,{

                }).add(TAG)
    }

    /**
     *scan ： 将数据按照一定逻辑聚合起来
     */
    fun scan(){
        Observable.just(1,2,3,4,5)
                .scan(object : BiFunction<Int, Int, Int> {
                    override fun apply(t1: Int, t2: Int): Int {
                        return t1 + t2
                    }
                }).subscribe({
                    Log.e(TAG, "scan result is $it")
                } ,{

                }).add(TAG)
    }

    /**
     * window :
     */
    fun window (){
        Observable.just(1,2,3,4,5)
                .window(2)
                .subscribe({
                    it.subscribe({
                        Log.e(TAG, " window result is $it.")
                    } ,{

                    }).add(TAG)
                } ,{

                }).add(TAG)
    }


    fun getData() : ArrayList<Person>{
        val personList = arrayListOf<Person>()
        personList.add(Person("nam1", arrayListOf(Plan(arrayListOf("hao")), Plan(arrayListOf("hao")))))
        personList.add(Person("nam2", arrayListOf(Plan(arrayListOf("liang")), Plan(arrayListOf("liang")))))
        personList.add(Person("nam3", arrayListOf(Plan(arrayListOf("cha")), Plan(arrayListOf("cha")))))
        return personList
    }
}