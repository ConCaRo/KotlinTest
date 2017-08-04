package testco.kotlin.domain.model

/**
 * Created by Concaro on 8/2/2017.
 */
class SongModel(val name: String,
                val singer: SingerModel?,
                val artist: ArtistModel?,
                val release_date: String,
                val lyric: String?) {
}