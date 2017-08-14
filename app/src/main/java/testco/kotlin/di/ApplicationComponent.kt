package testco.kotlin.di

import dagger.Component
import testco.kotlin.di.module.ListMusicModule
import testco.kotlin.di.subcomponent.ListMusicComponent
import testco.kotlin.ui.App
import testco.kotlin.ui.fragment.ListMusicFragment
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, DomainModule::class))
interface ApplicationComponent {
    val app: App
    /*fun context(): Context
    fun realm(): Realm
    fun dbHelper(): DBHelper
    fun restService(): RestService
    fun dataRepository(): DataRepository
    fun getAlbumsUsecase(): GetAlbumsUsecase*/

    fun inject(application: App)
    fun inject(fragment: ListMusicFragment)

    // Sub Components
    fun plus(module: ListMusicModule): ListMusicComponent


}