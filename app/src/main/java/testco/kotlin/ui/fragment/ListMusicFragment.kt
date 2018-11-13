package testco.kotlin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.databinding.FragmentListMusicBinding
import testco.kotlin.di.module.ListMusicModule
import testco.kotlin.ui.activity.DetailMusicActivity
import testco.kotlin.ui.adapter.MusicAdapter
import testco.kotlin.ui.viewmodel.ListMusicViewModel
import javax.inject.Inject

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicFragment : BaseFragment() {

    lateinit @Inject var viewModel: ListMusicViewModel
    lateinit var fragmentBinding: FragmentListMusicBinding

    lateinit @Inject var realm: Realm
    /* lateinit @Inject var gson: Gson
    lateinit @Inject var dataRepository: DataRepository*/

    companion object {
        fun newInstance(): ListMusicFragment = ListMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_list_music
    }

    override fun initInjection() {
        super.initInjection()
        getApplicationComponent().plus(ListMusicModule(this))
                .injectTo(this)
    }

    override fun initBinding() {
        fragmentBinding = FragmentListMusicBinding.bind(rootView)
        fragmentBinding.viewModel = viewModel
    }

    override fun init() {
        initAdapter()

        //  Test gson
        /*val json = gson.toJson(DummyData.getListAlbumModel())
        Log.d("Trong", json)*/
        // Test Realm
        /*realm.beginTransaction()
        realm.deleteAll();
        realm.commitTransaction()*/

        viewModel.loadData()
    }

    fun initAdapter() {
        recyclerview.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        recyclerview.adapter = MusicAdapter(itemOnClick, requireActivity(), viewModel)
    }

    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
        Log.d("MusicAdapter", "position clicked " + position)
        val intent = DetailMusicActivity.callingIntent(requireActivity(), viewModel?.items[position]?.id!!)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroy()
    }
}