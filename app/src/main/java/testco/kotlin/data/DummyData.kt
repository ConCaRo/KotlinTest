package testco.kotlin.data

import io.reactivex.Observable
import testco.kotlin.data.model.AlbumModel
import testco.kotlin.data.model.ArtistModel
import testco.kotlin.data.model.SingerModel
import testco.kotlin.data.model.SongModel

/**
 * Created by Concaro on 7/17/2017.
 */
class DummyData {

    companion object {

        fun getListAlbum(): Observable<List<AlbumModel>> {
            val music0 = AlbumModel("Album 1", getListArtist(), getListSong(), "123-123-23")
            val music1 = AlbumModel("Album 2", getListArtist(), getListSong(), "123-123-23")
            val music2 = AlbumModel("Album 3", getListArtist(), getListSong(), "123-123-23")
            val music3 = AlbumModel("Album 4", getListArtist(), getListSong(), "123-123-23")
            val music4 = AlbumModel("Album 5", getListArtist(), getListSong(), "123-123-23")
            val music5 = AlbumModel("Album 6", getListArtist(), getListSong(), "123-123-23")

            return Observable.just(listOf(music0, music1, music2, music3, music4, music5))
        }

        fun getListArtist(): ArrayList<ArtistModel> {
            val artist0 = ArtistModel("Artist 0", "123-123-23")
            val artist1 = ArtistModel("Artist 0", "123-123-23")
            val artist2 = ArtistModel("Artist 0", "123-123-23")
            val artist3 = ArtistModel("Artist 0", "123-123-23")
            val artist4 = ArtistModel("Artist 0", "123-123-23")
            val artist5 = ArtistModel("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSinger(): ArrayList<SingerModel> {
            val artist0 = SingerModel("Artist 0", "123-123-23")
            val artist1 = SingerModel("Artist 0", "123-123-23")
            val artist2 = SingerModel("Artist 0", "123-123-23")
            val artist3 = SingerModel("Artist 0", "123-123-23")
            val artist4 = SingerModel("Artist 0", "123-123-23")
            val artist5 = SingerModel("Artist 0", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSong(): ArrayList<SongModel> {
            val artist0 = SongModel("Song 0", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist1 = SongModel("Song 1", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist2 = SongModel("Song 2", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist3 = SongModel("Song 3", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist4 = SongModel("Song 4", getSinger(), getArtist(), "123-123-23", "Hello lyric")
            val artist5 = SongModel("Song 5", getSinger(), getArtist(), "123-123-23", "Hello lyric")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getSinger(): SingerModel {
            return SingerModel("Singer 1", "10-20-1900")
        }

        fun getArtist(): ArtistModel {
            return ArtistModel("Artist 1", "10-20-1900")
        }
    }


}