package testco.kotlin.di.subcomponent

import dagger.Subcomponent
import testco.kotlin.di.module.DetailMusicModule
import testco.kotlin.di.scope.FragmentScope
import testco.kotlin.ui.fragment.DetailMusicFragment

/**
 * Created by Concaro on 8/9/2017.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(
        DetailMusicModule::class))
interface DetailMusicComponent {

    fun injectTo(fragment: DetailMusicFragment)
}