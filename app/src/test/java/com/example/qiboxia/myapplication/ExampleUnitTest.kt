package com.example.qiboxia.myapplication

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun randomNum(){
        val random = Random()
        System.out.println("randomInt is ")
        for(i in 0..100){
            val randomInt = random.nextInt(100)
            System.out.print("$randomInt、")
        }

    }

    @Test
    fun testSubArray(){
        val array = ArrayList<String>()
        array.add("dsahj ")
        array.add("dsahj ")

        array.add("dsahj ")
        array.add("dsahj ")
        array.add("dsahj ")
        val subArray = array.subList(0 , 2)
        System.out.print("subarray size is ${subArray.size}")
    }


    @Test
    fun testSubString(){
        val testStr = "rong://com.xiangwushuo.android/conversation/private?targetId=7F731T5A1D0N63164117755690&title=%E6%B6%88%E6%81%AF"
        val subString=  testStr.split("=")
        System.out.print("subsString is ${subString[1]}")
        val id = subString[1].removeSuffix("&title")
        System.out.println("id is $id")
        System.out.print("name is ${subString[2]}")
    }

    @Test
    fun testXor(){
        System.out.println("true true :${true.xor(true)}")
        System.out.println("true false :${true.xor(false)}")
        System.out.println("false true :${false.xor(true)}")
        System.out.println("false false :${false.xor(false)}")
    }
}
