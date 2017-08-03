package testco.kotlin.data.repository.datasource

import io.reactivex.Observable
import testco.kotlin.data.model.AlbumModel
import testco.kotlin.data.rest.RestApi

/**
 * Created by Concaro on 8/3/2017.
 * Get data from api, need to implement error and store to db here
 */
class CloudDataStore(val restApi: RestApi) : DataStore {

    override fun requestAlbums(id: String, artist: String): Observable<List<AlbumModel>> {
        return restApi.requestAlbums(id, artist).doAfterNext { /*DO somtehing here*/ } as Observable<List<AlbumModel>>
    }

    override fun requestAlbum(id: String): Observable<AlbumModel> {
        return restApi.requestAlbum(id).doAfterNext { /*DO somtehing here*/ } as Observable<AlbumModel>
    }

}