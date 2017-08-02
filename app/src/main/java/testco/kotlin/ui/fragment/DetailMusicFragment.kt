package testco.kotlin.ui.fragment

import testco.kotlin.R

/**
 * Created by Concaro on 7/17/2017.
 */
class DetailMusicFragment : BaseFragment() {

    companion object {
        fun newInstance() : DetailMusicFragment = DetailMusicFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_detail_music
    }

    override fun init() {

    }
}