package testco.kotlin.domain.repository

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity

/**
 * Created by Concaro on 8/3/2017.
 */
interface DataRepository {

    fun requestAlbums(refresh: Boolean, id: String, artist: String): Observable<List<AlbumEntity>>

    fun requestAlbum(refresh: Boolean, id: String): Observable<AlbumEntity>
}