package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.model.AlbumModel

/**
 * Created by Concaro on 8/3/2017.
 * Get Data from database
 */
class DiskDataStore(val dbHelper: DBHelper) : DataStore {

    override fun requestAlbums(id: String, artist: String): Observable<List<AlbumModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestAlbum(id: String): Observable<AlbumModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}