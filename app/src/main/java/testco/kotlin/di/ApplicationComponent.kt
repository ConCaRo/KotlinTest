package testco.kotlin.di

import dagger.Component
import testco.kotlin.ui.App
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, DomainModule::class))
interface ApplicationComponent {

    fun inject(application: App)

}