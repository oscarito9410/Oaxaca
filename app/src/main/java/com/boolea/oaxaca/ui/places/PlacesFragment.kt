package com.boolea.oaxaca.ui.places

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.ui.base.BaseFragment
import com.boolea.oaxaca.ui.utils.snappyRecyclerView.CenterZoomLayoutManager
import com.boolea.oaxaca.ui.utils.snappyRecyclerView.SnappingRecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_places.*
import java.io.Serializable


/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class PlacesFragment : BaseFragment(), PlaceAdapter.onItemSelectedListener, SnappingRecyclerView.SnappingRecyclerViewListener, OnMapReadyCallback {

    companion object {
        val ARG_LIST_PLACES = "arg_list_place"
        fun newInstance(places: List<Place>): PlacesFragment {
            val args = Bundle()
            args.putSerializable(ARG_LIST_PLACES, places as Serializable)
            val fragment = PlacesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    var mListPlaces: List<Place>? = null

    var mMap: GoogleMap? = null

    var mMarkes: MutableList<Marker> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments!!.containsKey(ARG_LIST_PLACES))
            mListPlaces = arguments!!.getSerializable(ARG_LIST_PLACES) as List<Place>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(com.boolea.oaxaca.R.layout.fragment_places, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = CenterZoomLayoutManager(context!!, LinearLayoutManager.HORIZONTAL, false)
        rvPlacesDescription.layoutManager = layoutManager
        val adapter = PlaceAdapter(context!!, ArrayList(mListPlaces))
        rvPlacesDescription.adapter = adapter
        rvPlacesDescription.listener = this
        adapter.listener = this
        val mapFragment = childFragmentManager.findFragmentById(com.boolea.oaxaca.R.id.map) as? SupportMapFragment
        mapFragment!!.getMapAsync(this)
    }

    override fun onItemSelected(item: Any, position: Int) {
        val place: Place = item as Place
        val location = CameraUpdateFactory.newLatLngZoom(
                place.latLng, 15f)
        mMap!!.animateCamera(location)
        mMarkes[position].showInfoWindow()
    }

    override fun onPositionChange(position: Int) {
        val location = CameraUpdateFactory.newLatLngZoom(
                mListPlaces!![position].latLng, 15f)
        mMap!!.animateCamera(location)
        mMarkes[position].showInfoWindow()
    }

    override fun onScroll(dx: Int, dy: Int) {

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        mListPlaces!!.forEach {
            val marker = mMap!!.addMarker(MarkerOptions().position(it.latLng!!).title(it.name))
            marker.tag = it
            mMarkes.add(marker)
        }
        mMap!!.setInfoWindowAdapter(PlaceInfoWindowAdapter(context!!))
        mMap!!.setOnInfoWindowClickListener {
            val place= it.tag as Place
            getBaseActivity().pushSingleFragment(PlacesDetailFragment.newInstance(place), PlacesDetailFragment.TAG, true)

        }
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(17.054230, -96.713226), 9f))
    }


}