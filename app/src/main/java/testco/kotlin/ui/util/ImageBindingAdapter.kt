package testco.kotlin.ui.util

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * Created by Concaro on 8/8/2017.
 */
object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imv: ImageView, url: String) {
        ImageUtil.loaImage(imv.context, imv, "", url)
    }
}