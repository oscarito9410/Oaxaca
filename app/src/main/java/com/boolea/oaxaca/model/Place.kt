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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Place) return false

        if (name != other.name) return false
        if (description != other.description) return false
        if (image != other.image) return false
        if (zone != other.zone) return false
        if (latLng != other.latLng) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + image
        result = 31 * result + (zone?.hashCode() ?: 0)
        result = 31 * result + (latLng?.hashCode() ?: 0)
        return result
    }


}