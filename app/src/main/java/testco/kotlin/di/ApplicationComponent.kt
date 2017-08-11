package testco.kotlin.di

import dagger.Component
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
    /*fun context(): Context
    fun realm(): Realm*/

}