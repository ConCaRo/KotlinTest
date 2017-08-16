package testco.kotlin.data.cache

import io.realm.Realm
import javax.inject.Inject

/**
 * Created by Concaro on 8/3/2017.
 */
class DBHelper @Inject constructor(val realm: Realm) {

    /*fun saveAlbums(items: List<AlbumEntity>) {
        realm.copyToRealmOrUpdate(items)
    }

    fun saveAlbum(item: AlbumEntity) {
        realm.copyToRealmOrUpdate(item)
    }

    fun getAlbums(): Observable<List<AlbumEntity>> {
        return Observable.create(ObservableOnSubscribe<List<AlbumEntity>> { e ->
            val lsItems = realm.where(AlbumEntity::class.java).findAll()
            lsItems?.let {
                e.onNext(realm.copyFromRealm(lsItems))
                e.onComplete()
            }
        })

    }

    fun getAlbum(id: Int): Observable<AlbumEntity> {
        return Observable.create(ObservableOnSubscribe { e ->
            val item = realm.where(AlbumEntity::class.java).equalTo("id", id).findFirst()
            item?.let {
                e.onNext(realm.copyFromRealm(item))
                e.onComplete()
            }
        })
    }*/
}