package testco.kotlin.data

import testco.kotlin.model.Music

/**
 * Created by Concaro on 7/17/2017.
 */
class DummyData {

    companion object {

        fun getListMusic(): ArrayList<Music> {
            val music0 = Music(0 , "Son TUong", "")
            val music1 = Music(1 , "Son TUong", "")
            val music2 = Music(2 , "Son TUong", "")
            val music3 = Music(3 , "Son TUong", "")
            val music4 = Music(4 , "Son TUong", "")
            val music5 = Music(5 , "Son TUong", "")

            return arrayListOf(music0, music1, music2, music3, music4, music5)
        }
    }


}