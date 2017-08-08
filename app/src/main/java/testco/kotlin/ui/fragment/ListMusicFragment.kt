package testco.kotlin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.data.DummyData
import testco.kotlin.databinding.FragmentListMusicBinding
import testco.kotlin.ui.activity.DetailMusicActivity
import testco.kotlin.ui.adapter.MusicAdapter
import testco.kotlin.ui.viewmodel.ListMusicViewModel

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicFragment : BaseFragment() {

    lateinit var viewModel: ListMusicViewModel
    lateinit var fragmentBinding: FragmentListMusicBinding

    companion object {
        fun newInstance(): ListMusicFragment = ListMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_list_music
    }

    override fun initBinding() {
        viewModel = ListMusicViewModel(activity, DummyData.getListAlbumModel())
        fragmentBinding = FragmentListMusicBinding.bind(rootView)
        fragmentBinding.viewModel = viewModel
    }

    override fun init() {
        initAdapter()
    }

    fun initAdapter() {
        recyclerview.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        recyclerview.adapter = MusicAdapter(itemOnClick,  activity, viewModel)
    }

    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
        Log.d("MusicAdapter", "position clicked " + position)
        val intent = DetailMusicActivity.callingIntent(activity, position)
        startActivity(intent)
    }


}