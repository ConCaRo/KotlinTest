package testco.kotlin.data.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by Concaro on 8/3/2017.
 */
interface RestService {

    @GET("ablums")
    fun requestAlbums(@Query("mbid") id: String, @Query("artist") artist: String): Observable<Objects>

    @GET("album")
    fun requestAlbum(@Query("mbid") id: String): Observable<Objects>
}