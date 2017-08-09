package testco.kotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class ApplicationModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = app



}