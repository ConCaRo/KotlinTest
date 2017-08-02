package testco.kotlin.data.net

import io.reactivex.Observable
import java.util.*

/**
 * Created by Concaro on 8/2/2017.
 */
class RestApiImpl(val restApi: RestApi) {

    fun getAlbums(mbid: String, artist: String): Observable<Objects> {
        return restApi.requestAlbums(mbid, artist)
    }

    fun getAlbum(mbid: String): Observable<Objects> {
        return restApi.requestAlbum(mbid)
    }

}