package com.boolea.oaxaca.ui.places

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.boolea.oaxaca.R
import com.boolea.oaxaca.manager.DataManager
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.ui.base.BaseActivity
import com.boolea.oaxaca.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_places.*
import java.io.Serializable

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class PlacesFragment : BaseFragment(), PlaceAdapter.onItemSelectedListener {

    companion object {
        val TAG = PlacesFragment.toString()
        val ARG_LIST_PLACES = "ARG_LIST_PLACES"


        fun newInstance(places: List<Place>): PlacesFragment {
            val args = Bundle()
            args.putSerializable(ARG_LIST_PLACES, places as Serializable)
            val fragment = PlacesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    var mListPlaces: List<Place>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments!!.containsKey(ARG_LIST_PLACES))
            mListPlaces = arguments!!.getSerializable(ARG_LIST_PLACES) as List<Place>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_places, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPlacesDescription.layoutManager = GridLayoutManager(context!!, 2)
        val adapter = PlaceAdapter(context!!, ArrayList(mListPlaces))
        rvPlacesDescription.adapter = adapter
        adapter.listener = this
    }

    override fun onItemSelected(item: Any, position: Int) {
        val place: Place = item as Place
        getBaseActivity().pushSingleFragment(PlacesDetailFragment.newInstance(place), PlacesDetailFragment.TAG, true)
    }


}