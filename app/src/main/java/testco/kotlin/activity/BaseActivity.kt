package testco.kotlin.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_toolbar.*
import testco.kotlin.R

/**
 * Created by Concaro on 7/17/2017.
 */
open abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getContentView())

        setSupportActionBar(toolbar)
    }

    open fun getContentView(): Int {
        return R.layout.layout_activity_container
    }




}