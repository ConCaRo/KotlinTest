package testco.kotlin.di

import android.content.Context
import dagger.Component
import io.realm.Realm
import testco.kotlin.data.cache.DBHelper
import testco.kotlin.data.rest.RestService
import testco.kotlin.domain.interactor.GetAlbumsUsecase
import testco.kotlin.domain.repository.DataRepository
import testco.kotlin.ui.App
import testco.kotlin.ui.fragment.ListMusicFragment
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, DomainModule::class))
interface ApplicationComponent {

    fun inject(application: App)
    fun inject(fragment: ListMusicFragment)

    val app: App
    fun context(): Context
    fun realm(): Realm
    fun dbHelper() : DBHelper
    fun restService(): RestService
    fun dataRepository(): DataRepository
    fun getAlbumsUsecase() : GetAlbumsUsecase


}