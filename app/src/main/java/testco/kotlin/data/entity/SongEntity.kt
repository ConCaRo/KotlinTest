package testco.kotlin.data.entity

/**
 * Created by Concaro on 8/2/2017.
 */
class SongEntity(val name: String,
                 val singer: SingerEntity?,
                 val artist: ArtistEntity?,
                 val release_date: String,
                 val lyric: String?) {
}