package testco.kotlin.data.entity

import io.realm.RealmObject
import io.realm.annotations.RealmClass

/**
 * Created by Concaro on 8/2/2017.
 */
@RealmClass
open class SingerEntity(var name: String,
                   var date_of_birth: String?) : RealmObject(){
    constructor() : this("", "")
}