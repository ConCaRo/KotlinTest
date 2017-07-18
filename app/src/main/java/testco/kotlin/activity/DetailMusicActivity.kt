package testco.kotlin.activity

import android.os.Bundle
import testco.kotlin.R
import testco.kotlin.fragment.DetailMusicFragment

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, DetailMusicFragment.newInstance())
                .commit()
        initToolbar()
    }

    fun initToolbar() {
        supportActionBar?.title = "Detail Music"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}