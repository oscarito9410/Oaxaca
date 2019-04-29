package com.boolea.oaxaca.ui.places

import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.boolea.oaxaca.model.Place
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_window_place.view.*
import java.lang.Exception


/**

Created by oscar on 28/04/19
operez@na-at.com.mx
 */
class PlaceInfoWindowAdapter(val context: Context) : GoogleMap.InfoWindowAdapter {

    var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(context)
    }


    override fun getInfoContents(p0: Marker?): View? {
        return null
    }

    override fun getInfoWindow(marker: Marker?): View {
        val v = mInflater!!.inflate(com.boolea.oaxaca.R.layout.item_window_place, null)
        val place = marker!!.tag as Place
        v.tvNombreLugar.text = place.name
        v.tvDireccion.text = place.description
        Picasso.get().load(place.image).into(v.imageLugarItem,object : Callback{
            override fun onSuccess() {
                if (marker.isInfoWindowShown) {
                    marker.hideInfoWindow()
                    Picasso.get().load(place.image).into(v.imageLugarItem)
                    marker.showInfoWindow()
                }
            }

            override fun onError(e: Exception?) {
                //Empty method
            }

        })
        return v

    }
}