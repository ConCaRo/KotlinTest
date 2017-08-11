package testco.kotlin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.fernandocejas.sample.framework.interactor.UseCaseObserver
import com.google.gson.Gson
import io.realm.Realm
import kotlinx.android.synthetic.main.layout_recyclerview.*
import testco.kotlin.R
import testco.kotlin.data.DummyData
import testco.kotlin.databinding.FragmentListMusicBinding
import testco.kotlin.domain.model.AlbumModel
import testco.kotlin.ui.activity.DetailMusicActivity
import testco.kotlin.ui.adapter.MusicAdapter
import testco.kotlin.ui.viewmodel.ListMusicViewModel
import javax.inject.Inject

/**
 * Created by Concaro on 7/17/2017.
 */
class ListMusicFragment : BaseFragment() {

    lateinit var viewModel: ListMusicViewModel
    lateinit var fragmentBinding: FragmentListMusicBinding

    lateinit @Inject var realm: Realm
    lateinit @Inject var gson: Gson
    /*lateinit @Inject var getAlbumsUsecase: GetAlbumsUsecase*/

    companion object {
        fun newInstance(): ListMusicFragment = ListMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_list_music
    }

    override fun initInjection() {
        getApplicationComponent().inject(this)
    }

    override fun initBinding() {
        viewModel = ListMusicViewModel(activity, DummyData.getListAlbumModel())
        fragmentBinding = FragmentListMusicBinding.bind(rootView)
        fragmentBinding.viewModel = viewModel
    }

    override fun init() {
        initAdapter()

        val json = gson.toJson(DummyData.getListAlbumModel())
        Log.d("Trong", json)
        realm.deleteAll();

        /*getAlbumsUsecase.execute(AlbumsObserver(), GetAlbumsUsecase.Param.initValue(true, "", ""))*/
    }

    class AlbumsObserver : UseCaseObserver<List<AlbumModel>>() {

        override fun onNext(value: List<AlbumModel>) {
            super.onNext(value)
            Log.d("Trong", value.toString())
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            Log.d("Trong", e.printStackTrace().toString())
        }
    }


    fun initAdapter() {
        recyclerview.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        recyclerview.adapter = MusicAdapter(itemOnClick, activity, viewModel)
    }

    val itemOnClick: (View, Int, Int) -> Unit = { view, position, type ->
        Log.d("MusicAdapter", "position clicked " + position)
        val intent = DetailMusicActivity.callingIntent(activity, position)
        startActivity(intent)
    }
}