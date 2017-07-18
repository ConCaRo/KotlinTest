package testco.kotlin.fragment

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.activity.DetailMusicActivity
import testco.kotlin.adapter.MusicAdapter
import testco.kotlin.data.DummyData

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicFragment : BaseFragment() {

    companion object {
        fun newInstance(): ListMusicFragment = ListMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun init() {
        recyclerview.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        recyclerview.adapter = MusicAdapter(itemOnClick, DummyData.getListMusic(), activity)

    }

    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
        Log.d("MusicAdapter", "position clicked " + position)
        val intent = Intent().setClass(activity, DetailMusicActivity::class.java)
        startActivity(intent)
    }

}