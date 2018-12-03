package com.boolea.oaxaca.ui.places

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Place
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_place.view.*

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class PlaceAdapter(val ctx: Context, val items: ArrayList<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {


    interface onItemSelectedListener {
        fun onItemSelected(item: Any, position: Int)
    }

    var listener: onItemSelectedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_place, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var place = getItem(position)
        holder.title.text = place.name
        Glide.with(ctx).load(place.image).into(holder.ivDescription);
        holder.itemView.setOnClickListener { v ->
            run {
                if (listener != null)
                    listener!!.onItemSelected(place, position)
            }
        }
    }

    fun getItem(position: Int): Place {
        return items.get(position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tv_title_place
        val ivDescription = view.iv_place
    }
}