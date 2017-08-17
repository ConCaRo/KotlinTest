package testco.kotlin.data.repository.datasource

import testco.kotlin.data.DataStatus
import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.rest.RestApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Concaro on 8/3/2017.
 * Choose data from CACHE or from CLOUD
 */
@Singleton
class DataStoreFactory @Inject constructor(val restApi: RestApi, val dbHelper: DBHelper) {

    fun createCloudDataStore(): DataStore {
        return CloudDataStore(restApi, dbHelper)
    }

    fun createDiskDataStore(): DataStore {
        return DiskDataStore(dbHelper)
    }

    /**
     * Get data from CACHE or from CLOUD
     * @param dataStatus status of data from CACHE or from CLOUD
     */
    fun getDataStore(dataStatus: DataStatus): DataStore {
        if (dataStatus == DataStatus.CACHE) {
            return createDiskDataStore()
        } else if (dataStatus == DataStatus.CLOUD) {
            return createCloudDataStore()
        }
        return createCloudDataStore()
    }
}