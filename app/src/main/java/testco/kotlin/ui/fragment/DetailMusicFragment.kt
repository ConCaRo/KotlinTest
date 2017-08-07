package testco.kotlin.ui.fragment

import testco.kotlin.R
import testco.kotlin.data.DummyData
import testco.kotlin.databinding.FragmentDetailMusicBinding
import testco.kotlin.ui.viewmodel.DetailMusicViewModel

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicFragment : BaseFragment() {

    lateinit var viewModel: DetailMusicViewModel
    lateinit var fragmentBinding: FragmentDetailMusicBinding

    companion object {
        fun newInstance(): DetailMusicFragment = DetailMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_detail_music
    }

    override fun initBinding() {
        viewModel = DetailMusicViewModel(activity, DummyData.getListAlbumModel().get(0))
        fragmentBinding = FragmentDetailMusicBinding.bind(rootView)
        fragmentBinding.viewModel = viewModel
    }

    override fun init() {

    }
}