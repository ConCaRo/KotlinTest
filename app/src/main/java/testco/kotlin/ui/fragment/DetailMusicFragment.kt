package testco.kotlin.ui.fragment

import testco.kotlin.R
import testco.kotlin.databinding.FragmentDetailMusicBinding
import testco.kotlin.di.module.DetailMusicModule
import testco.kotlin.ui.viewmodel.DetailMusicViewModel
import javax.inject.Inject

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicFragment : BaseFragment() {

    lateinit @Inject var viewModel: DetailMusicViewModel
    lateinit var fragmentBinding: FragmentDetailMusicBinding

    companion object {
        fun newInstance(): DetailMusicFragment = DetailMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_detail_music
    }

    override fun initInjection() {
        super.initInjection()
        getApplicationComponent().plus(DetailMusicModule(this))
                .injectTo(this)
    }

    override fun initBinding() {
        val bundle = activity.intent.extras
        val id: Int = bundle.getInt("id", 0);
        viewModel.initData(id)
        fragmentBinding = FragmentDetailMusicBinding.bind(rootView)
        fragmentBinding.viewModel = viewModel
    }

    override fun init() {
        viewModel.loadData()
    }
}