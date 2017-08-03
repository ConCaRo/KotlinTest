package testco.kotlin.data.rest

import io.reactivex.Observable
import java.util.*

/**
 * Created by Concaro on 8/2/2017.
 */
interface RestApi {

    fun requestAlbums(id: String, artist: String): Observable<Objects>

    fun requestAlbum(id: String): Observable<Objects>
}