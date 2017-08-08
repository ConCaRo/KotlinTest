package testco.kotlin.ui.viewmodel

import android.content.Context
import testco.kotlin.domain.model.AlbumModel

/**
 * Created by Concaro on 8/7/2017.
 */
class DetailMusicViewModel(val context: Context, val albumModel: AlbumModel) {

    fun toStringListSongs() : String {
        var s : String = "Songs: \n"
        albumModel?.songs?.forEach { s += it.name + "\n" }
        return s
    }

    fun toStringListArtists() : String {
        var s : String = "Artists: \n"
        albumModel?.artists?.forEach { s += it.name + "\n" }
        return s
    }

}