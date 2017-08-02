package testco.kotlin.data

import testco.kotlin.ui.entity.Album

/**
 * Created by Concaro on 7/17/2017.
 */
class DummyData {

    companion object {

        fun getListMusic(): ArrayList<Album> {
            val music0 = Album(0 , "Son TUong", "")
            val music1 = Album(1 , "Son TUong", "")
            val music2 = Album(2 , "Son TUong", "")
            val music3 = Album(3 , "Son TUong", "")
            val music4 = Album(4 , "Son TUong", "")
            val music5 = Album(5 , "Son TUong", "")

            return arrayListOf(music0, music1, music2, music3, music4, music5)
        }
    }


}