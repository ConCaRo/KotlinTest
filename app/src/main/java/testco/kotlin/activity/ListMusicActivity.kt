package testco.kotlin.activity

import android.os.Bundle
import testco.kotlin.R
import testco.kotlin.fragment.ListMusicFragment

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, ListMusicFragment.newInstance())
                .commit()
        initToolbar()
    }

    fun initToolbar() {
        supportActionBar?.title = "List Musics"
    }
}