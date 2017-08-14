package testco.kotlin.data.rest

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity

/**
 * Created by Concaro on 8/2/2017.
 */
interface RestApi {

    fun requestAlbums(id: String, artist: String): Observable<List<AlbumEntity>>

    fun requestAlbum(id: String): Observable<AlbumEntity>
}