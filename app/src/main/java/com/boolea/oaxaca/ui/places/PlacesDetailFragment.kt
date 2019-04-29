package com.boolea.oaxaca.ui.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.ui.base.BaseFragment
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.content_place_detail.*
import kotlinx.android.synthetic.main.fragment_place_detail.*

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class PlacesDetailFragment : BaseFragment(), OnMapReadyCallback {
    companion object {
        val TAG = PlacesDetailFragment.toString()
        val ARG_SELECTED_PLACE = "selected_place"
        fun newInstance(place: Place): PlacesDetailFragment {
            val args = Bundle()
            args.putSerializable(ARG_SELECTED_PLACE, place)
            val fragment = PlacesDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }


    var mMap: GoogleMap? = null
    var mSelectedPlace: Place? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_place_detail, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSelectedPlace = getSelectedPlace()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInfoPlace()
    }

    fun setInfoPlace() {
        if (mSelectedPlace != null) {
            tvDescriptionDetail.text = mSelectedPlace!!.description
            Glide.with(context!!).load(mSelectedPlace!!.image).into(ivPlaceDetail)
            toolbar.title = mSelectedPlace!!.name
        }

        val mapFragment = childFragmentManager!!.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment!!.getMapAsync(this)
    }

    fun getSelectedPlace(): Place {
        return arguments!!.getSerializable(ARG_SELECTED_PLACE) as Place
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        mMap!!.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap!!.addMarker(MarkerOptions().position(mSelectedPlace!!.latLng!!).title(mSelectedPlace!!.name))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(mSelectedPlace!!.latLng!!, 18f))
    }

}