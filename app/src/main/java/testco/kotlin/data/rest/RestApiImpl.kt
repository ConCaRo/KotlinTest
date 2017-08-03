package testco.kotlin.data.rest

import io.reactivex.Observable
import java.util.*

/**
 * Created by Concaro on 8/2/2017.
 */
class RestApiImpl(val restService: RestService) : RestApi {

    override fun requestAlbums(id: String, artist: String): Observable<Objects> {
        return restService.requestAlbums(id, artist)
    }

    override fun requestAlbum(id: String): Observable<Objects> {
        return restService.requestAlbum(id)
    }
}