package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.model.AlbumModel

/**
 * Created by Concaro on 8/3/2017.
 */
interface DataStore {

    fun requestAlbums(id: String, artist: String): Observable<List<AlbumModel>>

    fun requestAlbum(id: String): Observable<AlbumModel>
}