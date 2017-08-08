package testco.kotlin.domain.model

/**
 * Created by Concaro on 8/2/2017.
 */
class AlbumModel(val name: String,
                 val cover: String,
                 val artists: List<ArtistModel>?,
                 val songs: List<SongModel>,
                 val release_date: String) {
}