package com.boolea.oaxaca.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boolea.oaxaca.R
import com.boolea.oaxaca.manager.DataManager
import com.boolea.oaxaca.model.Zone
import com.boolea.oaxaca.ui.base.BaseFragment
import com.boolea.oaxaca.ui.places.PlacesDetailFragment
import com.boolea.oaxaca.ui.places.PlacesFragment
import kotlinx.android.synthetic.main.fragment_place_options.*

/**
 * Created by Oscar Emilio Pérez Mtz on 02/12/2018.
operez@na-at.com.mx
 */
class PlacesOptionsFragment : BaseFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_place_options, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnZonCostas.setOnClickListener(this)
        btnZonaArqueologica.setOnClickListener(this)
        btnZonaCentro.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnZonCostas -> navigatePlaces(Zone.COAST)
            R.id.btnZonaArqueologica -> navigatePlaces(Zone.ARCHAEOLOGICAL)
            R.id.btnZonaCentro -> navigatePlaces(Zone.CENTER)
        }
    }

    fun navigatePlaces(typeZone: Zone) {
        getBaseActivity().pushSingleFragment(
                PlacesFragment.newInstance(DataManager.getPlacesBySection(context!!, typeZone)),
                PlacesDetailFragment.TAG,
                true
        )

    }

}