package testco.kotlin.ui.util

import android.databinding.BindingAdapter
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import testco.kotlin.domain.model.AlbumModel

/**
 * Created by Concaro on 8/8/2017.
 */
object ListBinding {

    @JvmStatic
    @BindingAdapter("app:items")
    fun setItems(recyclerView: RecyclerView, items: ObservableList<AlbumModel>) {
        recyclerView.adapter.notifyDataSetChanged()
    }
}