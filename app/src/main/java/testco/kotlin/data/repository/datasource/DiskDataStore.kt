package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.entity.AlbumEntity

/**
 * Created by Concaro on 8/3/2017.
 * Get Data from database
 */
class DiskDataStore(val dbHelper: DBHelper) : DataStore {

    override fun requestAlbums(refresh: Boolean, id: String, artist: String): Observable<List<AlbumEntity>> {
        return dbHelper.getAlbums()
    }

    override fun requestAlbum(refresh: Boolean, id: String): Observable<AlbumEntity> {
        return dbHelper.getAlbum(id.toInt())
    }
}