package testco.kotlin.data.cache

import io.reactivex.Observable
import io.realm.Realm
import testco.kotlin.data.entity.AlbumEntity
import testco.kotlin.data.exception.DatabaseException
import javax.inject.Inject

/**
 * Created by Concaro on 8/3/2017.
 */
class DBHelper @Inject constructor(var _realm: Realm) {


    fun getRealmInstance(): Realm = Realm.getDefaultInstance()

    @Throws(DatabaseException::class)
    fun saveAlbums(items: List<AlbumEntity>) {
        var realm: Realm = getRealmInstance()
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(items)
            realm.commitTransaction()
        } catch(error: Exception) {
            Throwable(DatabaseException(error))
        } finally {
            realm.close();
        }
    }

    @Throws(DatabaseException::class)
    fun saveAlbum(item: AlbumEntity) {
        var realm: Realm = getRealmInstance()
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(item)
            realm.commitTransaction()
        } catch(error: Exception) {
            Throwable(DatabaseException(error))
        } finally {
            realm.close();
        }
    }

    fun getAlbums(): Observable<List<AlbumEntity>> {
        return Observable.create({ e ->
            var realm: Realm = getRealmInstance()
            try {
                realm.beginTransaction()
                val lsItems = realm.where(AlbumEntity::class.java).findAll()
                lsItems?.let {
                    e.onNext(realm.copyFromRealm(lsItems))
                    e.onComplete()
                }
                realm.commitTransaction()
            } catch(error: Exception) {
                e.onError(DatabaseException(error))
            } finally {
                realm.close();
            }

        })

    }

    fun getAlbum(id: Int): Observable<AlbumEntity> {
        return Observable.create({ e ->
            var realm: Realm = getRealmInstance()
            try {
                realm.beginTransaction()
                val item = realm.where(AlbumEntity::class.java).equalTo("id", id).findFirst()
                item?.let {
                    e.onNext(realm.copyFromRealm(item))
                    e.onComplete()
                }
                realm.commitTransaction()
            } catch(error: Exception) {
                e.onError(DatabaseException(error))
            } finally {
                realm.close();
            }
        })
    }
}