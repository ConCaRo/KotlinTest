package testco.kotlin.di

import dagger.Component
import testco.kotlin.di.module.DetailMusicModule
import testco.kotlin.di.module.ListMusicModule
import testco.kotlin.di.subcomponent.DetailMusicComponent
import testco.kotlin.di.subcomponent.ListMusicComponent
import testco.kotlin.ui.App
import testco.kotlin.ui.fragment.DetailMusicFragment
import testco.kotlin.ui.fragment.ListMusicFragment
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, DomainModule::class))
interface ApplicationComponent {
    val app: App
    /*fun inject(fragment: BaseFragment)*/
    /*fun context(): Context
    fun realm(): Realm
    fun dbHelper(): DBHelper
    fun restService(): RestService
    fun dataRepository(): DataRepository
    fun getAlbumsUsecase(): GetAlbumsUsecase*/

    fun inject(application: App)
    fun inject(fragment: ListMusicFragment)
    fun inject(fragment: DetailMusicFragment)

    // Sub Components
    fun plus(module: ListMusicModule): ListMusicComponent
    fun plus(module: DetailMusicModule): DetailMusicComponent


}