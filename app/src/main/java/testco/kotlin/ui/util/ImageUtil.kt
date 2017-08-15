package testco.kotlin.ui.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import testco.kotlin.R

/**
 * Created by Concaro on 8/8/2017.
 */
class ImageUtil {

    companion object {

        val requestOptions: RequestOptions = RequestOptions().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)

        fun loaImage(ctx: Context, imv: ImageView, thumb: String, org: String?) {
            Glide.with(ctx).load(org)
                    .apply(requestOptions)
                    .into(imv);
        }

    }
}