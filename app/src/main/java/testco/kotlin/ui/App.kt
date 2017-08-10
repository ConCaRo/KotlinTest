package testco.kotlin.ui

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import testco.kotlin.di.ApplicationComponent
import testco.kotlin.di.ApplicationModule
import testco.kotlin.di.DaggerApplicationComponent


/**
 * Created by Concaro on 7/17/2017.
 */
class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initRealm()
        initDagger()
    }

    fun initRealm() {
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
                /*.schemaVersion(schemaVersion)
                .migration(realmMigrations)*/
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfig)
    }

    fun initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }
}