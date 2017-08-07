package testco.kotlin.data.repository

import io.reactivex.Observable
import testco.kotlin.data.entity.mapper.AlbumMapper
import testco.kotlin.data.repository.datasource.DataStoreFactory
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.domain.repository.DataRepository

/**
 * Created by Concaro on 8/3/2017.
 * Retrieve data
 */
class DataRepository(val albumMapper: AlbumMapper, val dataStoreFactory: DataStoreFactory) : DataRepository {

    override fun requestAlbums(refresh: Boolean, id: String, artist: String): Observable<List<AlbumModel>> {
        return dataStoreFactory.getDataStore().requestAlbums(id, artist)
                .map { albumMapper.transformCollection(it) }
    }

    override fun requestAlbum(refresh: Boolean, id: String): Observable<AlbumModel> {
        return dataStoreFactory.getDataStore().requestAlbum(id)
                .map { albumMapper.transform(it) }
    }

}