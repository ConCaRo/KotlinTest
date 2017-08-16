package testco.kotlin.data.entity

import io.realm.RealmObject
import io.realm.annotations.RealmClass

/**
 * Created by Concaro on 8/2/2017.
 */
@RealmClass
open class SongEntity(var name: String,
                      var singer: SingerEntity?,
                      var artist: ArtistEntity?,
                      var release_date: String,
                      var lyric: String?) : RealmObject() {
    constructor() : this("", SingerEntity(), ArtistEntity(), "", "")
}