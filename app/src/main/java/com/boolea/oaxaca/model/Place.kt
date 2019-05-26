package com.boolea.oaxaca.model

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class Place(idPlace: Int, zone: Zone, name: String, gallery: List<Gallery>, description: String, latLng: LatLng) : Serializable {

    var idPlace: Int = 0
    var name: String = ""
    var description: String = ""
    var image: Int = 0
    var zone: Zone? = null
    var latLng: CustomLatLng? = null
    var gallery: List<Gallery> = emptyList()


    init {
        this.idPlace = idPlace
        this.name = name
        this.description = description
        this.image = image
        this.zone = zone
        this.latLng = CustomLatLng(latLng.latitude, latLng.longitude)
        this.gallery = gallery
        this.image = gallery.first().image
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