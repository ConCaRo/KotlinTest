package testco.kotlin.data

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.entity.ArtistEntity
import testco.kotlin.data.entity.SingerEntity
import testco.kotlin.data.entity.SongEntity
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.domain.model.ArtistModel
import testco.kotlin.domain.model.SingerModel
import testco.kotlin.domain.model.SongModel

/**
 * Created by Concaro on 7/17/2017.
 */
class DummyData {

    companion object {

        fun getListAlbumModel(): List<AlbumModel> {
            val music0 = AlbumModel("Album 1", getListArtistModel(), getListSongModel(), "123-123-23")
            val music1 = AlbumModel("Album 2", getListArtistModel(), getListSongModel(), "123-123-23")
            val music2 = AlbumModel("Album 3", getListArtistModel(), getListSongModel(), "123-123-23")
            val music3 = AlbumModel("Album 4", getListArtistModel(), getListSongModel(), "123-123-23")
            val music4 = AlbumModel("Album 5", getListArtistModel(), getListSongModel(), "123-123-23")
            val music5 = AlbumModel("Album 6", getListArtistModel(), getListSongModel(), "123-123-23")

            return listOf(music0, music1, music2, music3, music4, music5)
        }

        fun getListArtistModel(): ArrayList<ArtistModel> {
            val artist0 = ArtistModel("Artist 0", "123-123-23")
            val artist1 = ArtistModel("Artist 0", "123-123-23")
            val artist2 = ArtistModel("Artist 0", "123-123-23")
            val artist3 = ArtistModel("Artist 0", "123-123-23")
            val artist4 = ArtistModel("Artist 0", "123-123-23")
            val artist5 = ArtistModel("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSingerModel(): ArrayList<SingerModel> {
            val artist0 = SingerModel("Artist 0", "123-123-23")
            val artist1 = SingerModel("Artist 0", "123-123-23")
            val artist2 = SingerModel("Artist 0", "123-123-23")
            val artist3 = SingerModel("Artist 0", "123-123-23")
            val artist4 = SingerModel("Artist 0", "123-123-23")
            val artist5 = SingerModel("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSongModel(): ArrayList<SongModel> {
            val artist0 = SongModel("Song 0", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")
            val artist1 = SongModel("Song 1", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")
            val artist2 = SongModel("Song 2", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")
            val artist3 = SongModel("Song 3", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")
            val artist4 = SongModel("Song 4", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")
            val artist5 = SongModel("Song 5", getSingerModel(), getArtistModel(), "123-123-23", "Hello lyric")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getSingerModel(): SingerModel {
            return SingerModel("Singer 1", "10-20-1900")
        }

        fun getArtistModel(): ArtistModel {
            return ArtistModel("Artist 1", "10-20-1900")
        }











        fun getListAlbum(): Observable<List<AlbumEntity>> {
            val music0 = AlbumEntity("Album 1", getListArtist(), getListSong(), "123-123-23")
            val music1 = AlbumEntity("Album 2", getListArtist(), getListSong(), "123-123-23")
            val music2 = AlbumEntity("Album 3", getListArtist(), getListSong(), "123-123-23")
            val music3 = AlbumEntity("Album 4", getListArtist(), getListSong(), "123-123-23")
            val music4 = AlbumEntity("Album 5", getListArtist(), getListSong(), "123-123-23")
            val music5 = AlbumEntity("Album 6", getListArtist(), getListSong(), "123-123-23")

            return Observable.just(listOf(music0, music1, music2, music3, music4, music5))
        }

        fun getListArtist(): ArrayList<ArtistEntity> {
            val artist0 = ArtistEntity("Artist 0", "123-123-23")
            val artist1 = ArtistEntity("Artist 0", "123-123-23")
            val artist2 = ArtistEntity("Artist 0", "123-123-23")
            val artist3 = ArtistEntity("Artist 0", "123-123-23")
            val artist4 = ArtistEntity("Artist 0", "123-123-23")
            val artist5 = ArtistEntity("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSinger(): ArrayList<SingerEntity> {
            val artist0 = SingerEntity("Artist 0", "123-123-23")
            val artist1 = SingerEntity("Artist 0", "123-123-23")
            val artist2 = SingerEntity("Artist 0", "123-123-23")
            val artist3 = SingerEntity("Artist 0", "123-123-23")
            val artist4 = SingerEntity("Artist 0", "123-123-23")
            val artist5 = SingerEntity("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSong(): ArrayList<SongEntity> {
            val artist0 = SongEntity("Song 0", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist1 = SongEntity("Song 1", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist2 = SongEntity("Song 2", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist3 = SongEntity("Song 3", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist4 = SongEntity("Song 4", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist5 = SongEntity("Song 5", getSinger(), getArtist(), "123-123-23", "Hello lyric")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getSinger(): SingerEntity {
            return SingerEntity("Singer 1", "10-20-1900")
        }

        fun getArtist(): ArtistEntity {
            return ArtistEntity("Artist 1", "10-20-1900")
        }
    }


}