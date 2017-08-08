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

        val listImages = listOf(
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/yang_zhuo_yong_cuo,_tibet-china-63.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/yellowstone-united_states-17.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/victoria-australia-31.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/valencia-spain-82.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/xigaze,_tibet-china-30.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/utah-united_states-96.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/utah-united_states-15.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/utah-united_states-88.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/umm_al_quwain-united_arab_emirates-13.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/texas-united_states-26.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/siuslaw_national_forest-united_states-92.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/the_minquiers-channel_islands-69.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/texas-united_states-84.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/tabuaeran-kiribati-50.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/stanislaus_river-united_states-61.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/s?ehitkamil-turkey-72.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/salinas_grandes-argentina-25.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/shadegan_refuge-iran-12.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/san_pedro_de_atacama-chile-43.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/ragged_island-the_bahamas-64.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/qinghai_lake-china-80.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/qesm_al_wahat_ad_dakhlah-egypt-56.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/riedstadt-germany-42.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/redwood_city-united_states-48.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/nyingchi,_tibet-china-98.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/ngari,_tibet-china-57.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/pozoantiguo-spain-99.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/ningaloo-australia-73.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/niederzier-germany-79.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/olympic_dam-australia-65.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/peedamulla-australia-40.jpg",
                "https://raw.githubusercontent.com/mikepenz/earthview-wallpapers/develop/thumb/nevado_tres_cruces_park-chile-89.jpg")

        fun getListAlbumModel(): List<AlbumModel> {
            val lsAlbums = ArrayList<AlbumModel>()
            for (i in 1..30) {
                val music = AlbumModel("Album " + i, listImages.get(i), getListArtistModel(),
                        getListSongModel(), "123-123-23")
                lsAlbums.add(music)
            }
            return lsAlbums
        }

        fun getListArtistModel(): ArrayList<ArtistModel> {
            val artist0 = ArtistModel("Artist 0", "123-123-23")
            val artist1 = ArtistModel("Artist 1", "123-123-23")
            val artist2 = ArtistModel("Artist 2", "123-123-23")
            val artist3 = ArtistModel("Artist 3", "123-123-23")
            val artist4 = ArtistModel("Artist 4", "123-123-23")
            val artist5 = ArtistModel("Artist 5", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSingerModel(): ArrayList<SingerModel> {
            val artist0 = SingerModel("Singer 0", "123-123-23")
            val artist1 = SingerModel("Singer 1", "123-123-23")
            val artist2 = SingerModel("Singer 2", "123-123-23")
            val artist3 = SingerModel("Singer 3", "123-123-23")
            val artist4 = SingerModel("Singer 4", "123-123-23")
            val artist5 = SingerModel("Singer 5", "123-123-23")

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

            val lsAlbums = ArrayList<AlbumEntity>()
            for (i in 1..20) {
                val music = AlbumEntity("Album " + i, listImages.get(i), getListArtist(),
                        getListSong(), "123-123-23")
                lsAlbums.add(music)
            }

            return Observable.just(lsAlbums)
        }

        fun getListArtist(): ArrayList<ArtistEntity> {
            val artist0 = ArtistEntity("Artist 1", "123-123-23")
            val artist1 = ArtistEntity("Artist 2", "123-123-23")
            val artist2 = ArtistEntity("Artist 3", "123-123-23")
            val artist3 = ArtistEntity("Artist 4", "123-123-23")
            val artist4 = ArtistEntity("Artist 5", "123-123-23")
            val artist5 = ArtistEntity("Artist 6", "123-123-23")

            return arrayListOf(artist0, artist1, artist2, artist3, artist4, artist5)
        }

        fun getListSinger(): ArrayList<SingerEntity> {
            val artist0 = SingerEntity("Singer 0", "123-123-23")
            val artist1 = SingerEntity("Singer 1", "123-123-23")
            val artist2 = SingerEntity("Singer 2", "123-123-23")
            val artist3 = SingerEntity("Singer 3", "123-123-23")
            val artist4 = SingerEntity("Singer 4", "123-123-23")
            val artist5 = SingerEntity("Singer 5", "123-123-23")

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