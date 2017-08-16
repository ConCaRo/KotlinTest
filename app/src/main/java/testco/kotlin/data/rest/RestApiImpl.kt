package testco.kotlin.data.rest

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import javax.inject.Inject

/**
 * Created by Concaro on 8/2/2017.
 */
class RestApiImpl @Inject constructor(val restService: RestService) : RestApi {

    override fun requestAlbums(id: String, artist: String): Observable<List<AlbumEntity>> {
        return restService.requestAlbums(id, artist).doAfterNext {  }
    }

    override fun requestAlbum(id: String): Observable<AlbumEntity> {
        return restService.requestAlbum(id)
    }
}