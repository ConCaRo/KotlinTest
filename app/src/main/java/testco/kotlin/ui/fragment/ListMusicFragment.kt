package testco.kotlin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.data.DummyData
import testco.kotlin.ui.activity.DetailMusicActivity
import testco.kotlin.ui.adapter.MusicAdapter
import testco.kotlin.ui.viewmodel.ListMusicViewModel

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
        recyclerview.adapter = MusicAdapter(itemOnClick, DummyData.getListAlbumModel(), activity)

    }

    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
        Log.d("MusicAdapter", "position clicked " + position)
        val intent = DetailMusicActivity.callingIntent(activity)
        startActivity(intent)
    }

}