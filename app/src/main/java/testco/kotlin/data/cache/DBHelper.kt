package testco.kotlin.data.cache

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.realm.Realm
import testco.kotlin.data.entity.AlbumEntity
import javax.inject.Inject

/**
 * Created by Concaro on 8/3/2017.
 */
class DBHelper @Inject constructor(var _realm: Realm) {


    fun getRealmInstance(): Realm = Realm.getDefaultInstance()

    fun saveAlbums(items: List<AlbumEntity>) {
        var realm: Realm = getRealmInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(items)
        realm.commitTransaction()
    }

    fun saveAlbum(item: AlbumEntity) {
        var realm: Realm = getRealmInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(item)
        realm.commitTransaction()
    }

    fun getAlbums(): Observable<List<AlbumEntity>> {
        return Observable.create(ObservableOnSubscribe<List<AlbumEntity>> { e ->
            var realm: Realm = getRealmInstance()
            realm.beginTransaction()
            val lsItems = realm.where(AlbumEntity::class.java).findAll()
            lsItems?.let {
                e.onNext(realm.copyFromRealm(lsItems))
                e.onComplete()
            }
            realm.commitTransaction()
        })

    }

    fun getAlbum(id: Int): Observable<AlbumEntity> {
        return Observable.create(ObservableOnSubscribe { e ->
            var realm: Realm = getRealmInstance()
            realm.beginTransaction()
            val item = realm.where(AlbumEntity::class.java).equalTo("id", id).findFirst()
            item?.let {
                e.onNext(realm.copyFromRealm(item))
                e.onComplete()
            }
            realm.commitTransaction()
        })
    }
}