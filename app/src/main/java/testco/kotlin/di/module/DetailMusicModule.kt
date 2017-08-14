package testco.kotlin.di.module

import dagger.Module
import testco.kotlin.di.FragmentModule
import testco.kotlin.ui.fragment.BaseFragment

/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class DetailMusicModule(fragment: BaseFragment) : FragmentModule(fragment) {

    /*@Provides
    fun provideViewModel(context: Context) : DetailMusicViewModel = DetailMusicViewModel(context)*/
}