package testco.kotlin.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import testco.kotlin.R
import testco.kotlin.databinding.ItemMusicBinding
import testco.kotlin.ui.viewmodel.ListMusicViewModel
import testco.kotlin.ui.viewmodel.MusicItemViewModel

/**
 * Created by Concaro on 7/17/2017.
 */
class MusicAdapter(val itemOnClick: (View, Int, Int) -> Unit,
                   val ctx: Context,
                   val viewModel: ListMusicViewModel) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MusicViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(v).onClick(itemOnClick)
    }

    override fun onBindViewHolder(holder: MusicViewHolder?, position: Int) {
        val albumModel = viewModel.items.get(position)
        holder?.itemBinding?.viewModel = MusicItemViewModel(ctx, albumModel)
        holder?.itemBinding?.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return viewModel?.items.size
    }


    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemBinding = ItemMusicBinding.bind(itemView)
    }

    fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(it, getAdapterPosition(), getItemViewType())
        }
        return this
    }

}