package com.boolea.oaxaca.ui.places.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Comment
import kotlinx.android.synthetic.main.item_place_comment.view.*

/**

Created by oscar on 15/05/19
operez@na-at.com.mx
 */
class PlaceCommentAdapter(private val context: Context,
                          private val comments: MutableList<Comment>) : RecyclerView.Adapter<PlaceCommentAdapter.ViewHolder>() {

    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_place_comment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comments.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(comments[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(comment: Comment) {
            itemView.tvComment.text = comment.text
        }
    }
}