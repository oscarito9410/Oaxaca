package com.boolea.oaxaca.model

import android.support.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class Place(zone: Zone, name: String, @DrawableRes image: Int, description: String, latLng: LatLng) : Serializable {

    var name: String = ""
    var description: String = ""
    var image: Int = 0
    var zone: Zone? = null
    var latLng: LatLng? = null

    init {
        this.name = name
        this.description = description
        this.image = image
        this.zone = zone
        this.latLng = latLng
    }

}