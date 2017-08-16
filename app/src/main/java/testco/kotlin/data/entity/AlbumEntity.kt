package testco.kotlin.data.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

/**
 * Created by Concaro on 8/2/2017.
 */
@RealmClass
open class AlbumEntity( var id: Int?,
                       var name: String?,
                       var cover: String,
                       var artists: RealmList<ArtistEntity>?,
                       var songs: RealmList<SongEntity>,
                       var release_date: String) : RealmObject() {
    constructor() : this(1, "", "", RealmList(), RealmList(), "")
}