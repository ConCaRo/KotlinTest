package testco.kotlin.data

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.entity.ArtistEntity
import testco.kotlin.data.entity.SingerEntity
import testco.kotlin.data.entity.SongEntity

/**
 * Created by Concaro on 7/17/2017.
 */
class DummyData {

    companion object {

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