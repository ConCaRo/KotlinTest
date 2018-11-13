package testco.kotlin.di

import android.content.Context
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import testco.kotlin.di.qualifier.ActivityContext
import testco.kotlin.di.scope.FragmentScope
import testco.kotlin.ui.fragment.BaseFragment

/**
 * Created by Concaro on 8/14/2017.
 */
@Module
abstract class FragmentModule(val fragment: BaseFragment) {

    @Provides
    @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides
    @FragmentScope
    @ActivityContext
    fun provideFragmentContext(): Context = fragment.requireContext()
}