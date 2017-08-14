package testco.kotlin.di

import android.app.Activity
import dagger.Module
import dagger.Provides
import testco.kotlin.ui.activity.BaseActivity
import javax.inject.Singleton

/**
 * Created by Concaro on 8/14/2017.
 */
@Module
abstract class ActivityModule(val activity: BaseActivity) {

    @Provides
    @Singleton
    fun provideActivity(): Activity = activity
}