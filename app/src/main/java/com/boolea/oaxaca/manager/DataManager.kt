package com.boolea.oaxaca.manager

import android.content.Context
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Place
import com.boolea.oaxaca.model.Zone
import com.google.android.gms.maps.model.LatLng

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
class DataManager {
    companion object Factory {

        fun getPlaces(ctx: Context): List<Place> {
            val listPlaces: MutableList<Place> = mutableListOf()
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_centro_historico), R.drawable.zocalo,
                    ctx.getString(R.string.description_centro_historico), LatLng(17.0605261,
                    -96.7252921)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_templo_sto_domingo), R.drawable.sto_domingo,
                    ctx.getString(R.string.description_sto_domingo), LatLng(17.06815, -96.713908)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_mertcado_veinte_nov),
                    R.drawable.mercado_veinte_noviembre, ctx.getString(R.string.description_mecado_veinte_nov),
                    LatLng(16.999464, -96.722999)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_teatro_macedonio),
                    R.drawable.teatro_macedonio, ctx.getString(R.string.description_teatro_macedonio),
                    LatLng(17.060788, -96.733455)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_calle_macedonio),
                    R.drawable.calle_macedonio, ctx.getString(R.string.description_calle_macedonio),
                    LatLng(17.06815, -96.713908)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_mercado_benito_juarez), R.drawable.mercado_benito_juarez,
                    ctx.getString(R.string.description_mercado_benito_juarez), LatLng(17.060788, -96.733455)))
            listPlaces.add(Place(Zone.CENTER, ctx.getString(R.string.title_museo_arte_prehispanico),
                    R.drawable.museo_rafino_prehispanico,
                    ctx.getString(R.string.description_museo_arte_prehispanico), LatLng(16.9458, -96.6875)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_monte_alban),
                    R.drawable.monte_alban, ctx.getString(R.string.description_monte_alban),
                    LatLng(16.9458, -96.6875)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_san_antonio_arrazola),
                    R.drawable.sn_antonio_arrazola,
                    ctx.getString(R.string.description_san_antonio_arrazola),
                    LatLng(17.0333, -96.7833)))
            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_san_jeronimo),
                    R.drawable.san_jeronimo,
                    ctx.getString(R.string.description_san_jeronimo),
                    LatLng(17.01568, -96.54082)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_sta_maria_tule),
                    R.drawable.sta_maria_tule, ctx.getString(R.string.description_sta_maria_tule),
                    LatLng(17.0333, -96.6167)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_teotitlan),
                    R.drawable.teotitlan, ctx.getString(R.string.description_teotitlan_valle),
                    LatLng(17.0333, -96.5)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_hierve_agua),
                    R.drawable.hieve_agua, ctx.getString(R.string.description_hierve_agua),
                    LatLng(16.8658, -96.2768)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_sn_bartolo),
                    R.drawable.sn_bartolo, ctx.getString(R.string.description_sn_bartolo),
                    LatLng(17.55, -97.2833)))

            listPlaces.add(Place(Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_zone_miltla),
                    R.drawable.zona_milta,
                    ctx.getString(R.string.description_zone_miltla),
                    LatLng(16.9167, -96.4)))

            listPlaces.add(Place(Zone.COAST, ctx.getString(R.string.title_huatulco),
                    R.drawable.huatulco,
                    ctx.getString(R.string.description_huatulco),
                    LatLng(15.75, -96.1333)))

            listPlaces.add(Place(Zone.COAST, ctx.getString(R.string.title_puerto_angel),
                    R.drawable.puerto_angel,
                    ctx.getString(R.string.description_puerto_angel),
                    LatLng(15.6667, -96.4833)))


            listPlaces.add(Place(Zone.COAST,
                    ctx.getString(R.string.title_puerto_escondido),
                    R.drawable.puerto_escondido,
                    ctx.getString(R.string.description_puerto_escondigo),
                    LatLng(17.0871, -97.3484)))



            return listPlaces
        }

        fun getPlacesBySection(ctx: Context, typeZone: Zone): List<Place> {
            return getPlaces(ctx).filter {
                it.zone == typeZone
            }
        }

    }
}