package com.example.gsonarraylistfromjsontest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.reflect.Type
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class GsonArrayListFromJsonTest {
    @Test
    fun testGsonArrayListFromJsonTest() {
        val emptyResult = toListOfStrings(emptyArrayJson)
        Assert.assertEquals(0, emptyResult?.size)

        val nullResult = toListOfStrings(emptyString)
        Assert.assertEquals(null, nullResult)
    }

    @Test
    fun testGsonArrayListFromJsonTest2() {
        //NOTE: compile requires explicit type specification for val
        val emptyResult: List<String>? = Gson().fromJson(emptyArrayJson, listOfStringType)
        Assert.assertEquals(0, emptyResult?.size)

        //NOTE: compile requires explicit type specification for val
        val nullResult: List<String>? = Gson().fromJson(emptyString, listOfStringType)
        Assert.assertEquals(null, nullResult)
    }

    @Test
    fun testGsonArrayListFromJsonTest3() {
        val emptyResult = Gson().fromJson(emptyArrayJson, Array<String>::class.java)?.toList()
        Assert.assertEquals(0, emptyResult?.size)

        val nullResult = Gson().fromJson(emptyString, Array<String>::class.java)?.toList()
        Assert.assertEquals(null, nullResult)
    }

    companion object {
        const val emptyArrayJson = "[]"
        const val emptyString = ""

        @JvmStatic
        val listOfStringType: Type = object : TypeToken<ArrayList<String>>() {}.type

        @JvmStatic
        fun toListOfStrings(json: String?): List<String>? {
            return json?.let {
                try {
                    Gson().fromJson(it, listOfStringType)
                } catch (e: JsonSyntaxException) {
                    null
                }
            }
        }
    }
}
