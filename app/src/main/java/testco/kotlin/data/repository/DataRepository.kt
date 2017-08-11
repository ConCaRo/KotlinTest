package testco.kotlin.data.repository

import io.reactivex.Observable
import testco.kotlin.data.entity.mapper.AlbumMapper
import testco.kotlin.data.repository.datasource.DataStoreFactory
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.domain.repository.DataRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Concaro on 8/3/2017.
 * Retrieve data
 */
@Singleton
class DataRepository @Inject constructor(val dataStoreFactory: DataStoreFactory,
                                         val albumMapper: AlbumMapper) : DataRepository {

    override fun requestAlbums(refresh: Boolean, id: String, artist: String): Observable<List<AlbumModel>> {
        return dataStoreFactory.getDataStore().requestAlbums(id, artist)
                .map { albumMapper.transformCollection(it) }
    }

    override fun requestAlbum(refresh: Boolean, id: String): Observable<AlbumModel> {
        return dataStoreFactory.getDataStore().requestAlbum(id)
                .map { albumMapper.transform(it) }
    }

}