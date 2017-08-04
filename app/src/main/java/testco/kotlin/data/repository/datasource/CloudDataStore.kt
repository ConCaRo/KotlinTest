package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.rest.RestApi

/**
 * Created by Concaro on 8/3/2017.
 * Get data from api, need to implement error and store to db here
 */
class CloudDataStore(val restApi: RestApi) : DataStore {

    override fun requestAlbums(id: String, artist: String): Observable<List<AlbumEntity>> {
        return restApi.requestAlbums(id, artist).doAfterNext { /*DO somtehing here*/ } as Observable<List<AlbumEntity>>
    }

    override fun requestAlbum(id: String): Observable<AlbumEntity> {
        return restApi.requestAlbum(id).doAfterNext { /*DO somtehing here*/ } as Observable<AlbumEntity>
    }

}