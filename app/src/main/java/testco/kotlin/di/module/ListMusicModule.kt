package testco.kotlin.di.module

import dagger.Module
import testco.kotlin.di.FragmentModule
import testco.kotlin.ui.fragment.BaseFragment

/**
 * Created by Concaro on 8/9/2017.
 */
@Module
class ListMusicModule(fragment: BaseFragment) : FragmentModule(fragment) {

    /*@Provides
    @FragmentScope
    fun provideViewModel() : ListMusicViewModel = ListMusicViewModel()*/
}