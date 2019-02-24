package com.example.qiboxia.myapplication

import android.util.Log
import org.json.JSONObject
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


    @Test
    fun formatAdd() {
        var address = "内蒙古自治区,涕淋过了盟,二连浩特区,11"
        address.removeSurrounding(",")
        val areaLevelCount = 4
        if(address.split(",").size == areaLevelCount){
            System.out.println("address is $address")
            return
        }
        address = address.replace("," ,"")
        var resultAdd = StringBuilder()
        val provinceRegular = arrayListOf("省" ,"自治区", "特别行政区" , "市")
        val areaRegular = arrayListOf("地区" ,"自治州", "盟" ,"直辖县级行政区划" ,"市","县")
        val countyRegular = arrayListOf("县" , "市" , "区" ,"旗")
        var tempAdd  = address
        for(province in provinceRegular){
            if(tempAdd.contains(province)){
                tempAdd = address.replaceFirst(province , "$province,")
                resultAdd .append( tempAdd.substring(0 ,tempAdd.indexOf(",") +1))
                tempAdd = tempAdd.substring(tempAdd.indexOf(",")  +1, tempAdd.length)
                break
            }
        }
        for(area in areaRegular){
            if(tempAdd.contains(area)){
                tempAdd = tempAdd.replaceFirst(area , "$area,")
                resultAdd.append(tempAdd.substring(0 , tempAdd.indexOf(",") +1))
                tempAdd = tempAdd.substring(tempAdd.indexOf("," ) +1 , tempAdd.length)
                break
            }
        }

        for(county in countyRegular){
            if(tempAdd.contains(county)){
                tempAdd = tempAdd.replaceFirst(county , "$county,")
                resultAdd .append(tempAdd)
                break
            }
        }
        System.out.println("address is $resultAdd")
    }


    @Test
    fun removeSurunding(){
        var test = ",1,,"
        test = test.removeSurrounding(",")
        System.out.println(test)
    }

    @Test
    fun testLength(){
        val number = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        val words = "好1234567890"
        System.out.println("number length is ${number.length}")
        System.out.println("words length is ${words.length}")
    }

    @Test
    fun testSubStr(){
        val str = "/pages/home/detail/index?code=101&topicId=746F145Z1D0S69303252137031&code=123"
        System.out.print("code is :${str.substring(str.indexOf("code=") +5 , str.indexOf("&"))}")
    }


    @Test
    fun str(){
        var s :String ?= null
        val l :Long ?= null
        val jsonObject = JSONObject("{}")
        val re  = jsonObject.optString("ah")

    }

}
