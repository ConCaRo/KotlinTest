package testco.kotlin.ui.fragment

import testco.kotlin.R
import testco.kotlin.data.DummyData
import testco.kotlin.databinding.FragmentDetailMusicBinding
import testco.kotlin.ui.viewmodel.DetailMusicViewModel

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicFragment : BaseFragment() {

    lateinit var detailViewModel: DetailMusicViewModel
    lateinit var detailMusicFragmentBinding: FragmentDetailMusicBinding

    companion object {
        fun newInstance(): DetailMusicFragment = DetailMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_detail_music
    }

    override fun init() {
        detailViewModel = DetailMusicViewModel(activity, DummyData.getListAlbumModel().get(0))
        detailMusicFragmentBinding = FragmentDetailMusicBinding.bind(rootView!!)
        detailMusicFragmentBinding.viewModel = detailViewModel
    }
}