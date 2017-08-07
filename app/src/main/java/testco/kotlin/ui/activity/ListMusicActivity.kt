package testco.kotlin.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import testco.kotlin.ui.fragment.ListMusicFragment

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context): Intent {
            return Intent(context, ListMusicActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(savedInstanceState, ListMusicFragment.newInstance())
        initToolbar("List Albums", false)
    }
}