package testco.kotlin.data.repository

import io.reactivex.Observable
import testco.kotlin.data.DataStatus
import testco.kotlin.data.entity.mapper.AlbumMapper
import testco.kotlin.data.exception.ErrorDivider
import testco.kotlin.data.repository.datasource.DataStoreFactory
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.domain.repository.DataRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Concaro on 8/3/2017.
 * Retrieve data and map Entity data to Model data (transfer from Data to Domain)
 */
@Singleton
class DataRepository @Inject constructor(val dataStoreFactory: DataStoreFactory,
                                         val albumMapper: AlbumMapper) : DataRepository {

    override fun requestAlbums(dataStatus: DataStatus, refresh: Boolean, id: String, artist: String)
            : Observable<List<AlbumModel>> {
        return dataStoreFactory.getDataStore(dataStatus)
                .requestAlbums(refresh, id, artist)
                .map { albumMapper.transformCollection(it) }
                .onErrorResumeNext { t: Throwable ->
                    Observable.error(ErrorDivider.divideDomainException(t))
                }
    }

    override fun requestAlbum(dataStatus: DataStatus, refresh: Boolean, id: String)
            : Observable<AlbumModel> {
        return dataStoreFactory.getDataStore(dataStatus)
                .requestAlbum(refresh, id)
                .map { albumMapper.transformToModel(it) }
                .onErrorResumeNext { t: Throwable ->
                    Observable.error(ErrorDivider.divideDomainException(t))
                }
    }

}