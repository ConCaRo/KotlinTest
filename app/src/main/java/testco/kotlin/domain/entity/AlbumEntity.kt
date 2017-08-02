package testco.kotlin.data.model

/**
 * Created by Concaro on 8/2/2017.
 */
class AlbumEntity(val name: String,
                  val artists: List<ArtistEntity>?,
                  val songs: List<SongEntity>,
                  val release_date: String) {
}