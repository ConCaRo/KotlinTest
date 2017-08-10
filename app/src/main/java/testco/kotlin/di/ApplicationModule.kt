package testco.kotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import testco.kotlin.ui.App
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class ApplicationModule(val application: App) {

    @Provides
    @Singleton
    fun provideApplication(): App = application

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application



}