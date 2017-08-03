package testco.kotlin.data.repository.datasource

import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.rest.RestApi

/**
 * Created by Concaro on 8/3/2017.
 */
class DataStoreFactory(val restApi: RestApi, val dbHelper: DBHelper) {

    fun createCloudDataStore(): DataStore {
        return CloudDataStore(restApi)
    }

    fun createDiskDataStore(): DataStore {
        return DiskDataStore(dbHelper)
    }

    fun getDataStore(): DataStore {
        return createCloudDataStore()
    }
}