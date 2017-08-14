package testco.kotlin.data.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import testco.kotlin.data.entity.AlbumEntity
import java.util.*

/**
 * Created by Concaro on 8/3/2017.
 */
interface RestService {

    @GET("albums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): Observable<List<AlbumEntity>>

    @GET("album")
    fun requestAlbum(@Query("mbid") id: String): Observable<Objects>
}