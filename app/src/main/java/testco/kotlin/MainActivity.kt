package testco.kotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.android.flexbox.FlexboxLayout

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import testco.kotlin.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        groupTags?.addView(buildTagsCatalogue(this, "Frank"))
        groupTags?.addView(buildTagsCatalogue(this, "Jim Chan"))
        groupTags?.addView(buildTagsCatalogue(this, "Hello"))
        groupTags?.addView(buildTagsCatalogue(this, "Ola"))

    }

    fun buildTagsCatalogue(context: Context, name: String): View {
        val layout = (context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.item_tag, null, false) as RelativeLayout
        val layoutParams = RelativeLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0, 0, 0, 0)
        layout.layoutParams = layoutParams

        val tvName = layout.findViewById<View>(R.id.tvTagName) as TextView

        tvName.text = name

        return layout
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
