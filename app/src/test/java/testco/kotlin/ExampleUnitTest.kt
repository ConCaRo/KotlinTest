package testco.kotlin

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test
import testco.kotlin.data.DummyData

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        /*val a: Int? = null
        val myString = a?.toString() ?: throw IllegalAccessException()
        System.out.println(myString)*/


        val json = Gson().toJson(DummyData.getListAlbumModel())
        System.out.println(json)
    }
}
