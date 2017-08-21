package testco.kotlin.data.rest

import io.reactivex.Observable
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.exception.ErrorDivider
import javax.inject.Inject

/**
 * Created by Concaro on 8/2/2017.
 * Get data from api, handle errors in this Rest layer
 */
class RestApiImpl @Inject constructor(val restService: RestService) : RestApi {

    override fun requestAlbums(id: String, artist: String): Observable<List<AlbumEntity>> {
        return restService.requestAlbums(id, artist)
                .onErrorResumeNext {
                    t: Throwable ->
                    Observable.error(ErrorDivider.divide(t))
                }
    }

    override fun requestAlbum(id: String): Observable<AlbumEntity> {
        return restService.requestAlbum(id).onErrorResumeNext {
            t: Throwable ->
            Observable.error(ErrorDivider.divide(t))
        }
    }
}