package com.example.qiboxia.myapplication

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.util.*

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
}
