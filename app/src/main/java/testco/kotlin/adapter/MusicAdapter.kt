package testco.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_music.view.*
import testco.kotlin.R
import testco.kotlin.model.Music

/**
 * Created by Concaro on 7/17/2017.
 */
class MusicAdapter(val items: ArrayList<Music>,
                   val ctx: Context) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MusicViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(v)

    }

    override fun onBindViewHolder(holder: MusicViewHolder?, position: Int) {
        holder?.text?.text = "Hello co ba"
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text = itemView.name
    }
}