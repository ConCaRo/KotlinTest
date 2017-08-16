package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.rest.RestApi



/**
 * Created by Concaro on 8/3/2017.
 * Get data from api, need to implement error and store to db here
 */
class CloudDataStore(val restApi: RestApi, val dbHelper: DBHelper) : DataStore {
    override fun requestAlbums(refresh: Boolean, id: String, artist: String): Observable<List<AlbumEntity>> {
        return restApi.requestAlbums(id, artist)
                .doOnNext { /*DO somtehing here : save data*/ } as Observable<List<AlbumEntity>>
    }

    override fun requestAlbum(refresh: Boolean, id: String): Observable<AlbumEntity> {
        return restApi.requestAlbum(id).doOnNext { /*DO somtehing here: save data*/ } as Observable<AlbumEntity>
    }

}