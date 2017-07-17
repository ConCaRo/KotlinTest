package testco.kotlin.fragment

import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.adapter.MusicAdapter
import testco.kotlin.data.DummyData

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicFragment : BaseFragment() {

    companion object {
        fun newInstance() : ListMusicFragment = ListMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun init() {
        recyclerview.layoutManager = GridLayoutManager(activity, 2)
        recyclerview.adapter = MusicAdapter(DummyData.getListMusic(), activity)
    }

}