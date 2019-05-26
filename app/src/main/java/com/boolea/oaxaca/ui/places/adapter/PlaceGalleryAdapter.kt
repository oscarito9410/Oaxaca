package com.boolea.oaxaca.ui.places.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Gallery
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gallery.view.*

/**

Created by oscar on 25/05/19
operez@na-at.com.mx
 */
class PlaceGalleryAdapter(private
                          val context: Context,
                          private val items: List<Gallery>) : RecyclerView.Adapter<PlaceGalleryAdapter.ViewHolder>() {


    val mInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(item: Gallery) {
            Picasso.get().load(item.image)
                    .into(itemView.ivGallery)
        }

    }

}