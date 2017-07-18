package testco.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.layout_toolbar.*
import testco.kotlin.R

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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}