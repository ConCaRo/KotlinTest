package testco.kotlin.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import testco.kotlin.ui.fragment.DetailMusicFragment

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context): Intent {
            return Intent(context, DetailMusicActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(savedInstanceState, DetailMusicFragment.newInstance())
        initToolbar("Detail Album", true)
    }

}