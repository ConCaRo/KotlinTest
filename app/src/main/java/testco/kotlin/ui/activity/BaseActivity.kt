package testco.kotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.layout_toolbar.*
import testco.kotlin.R
import testco.kotlin.ui.fragment.BaseFragment

/**
 * Created by Concaro on 7/17/2017.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        setSupportActionBar(toolbar)
    }

    open fun getContentView(): Int {
        return R.layout.layout_activity_container
    }

    fun initToolbar(title: String, hasBackButton: Boolean) {
        supportActionBar?.title = title
        if (hasBackButton) {
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

    }

    fun addFragment(savedInstanceState: Bundle?, fragment: BaseFragment) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> { consume { finish() } }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }


}