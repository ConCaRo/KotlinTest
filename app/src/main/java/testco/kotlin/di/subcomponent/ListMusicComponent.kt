package testco.kotlin.di.subcomponent

import dagger.Subcomponent
import testco.kotlin.di.module.ListMusicModule
import testco.kotlin.di.scope.FragmentScope
import testco.kotlin.ui.fragment.ListMusicFragment

/**
 * Created by Concaro on 8/9/2017.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(
        ListMusicModule::class))
interface ListMusicComponent {

    fun injectTo(fragment: ListMusicFragment)
}