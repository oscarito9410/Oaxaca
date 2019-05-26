package com.boolea.oaxaca.manager

import android.content.Context
import com.boolea.oaxaca.R
import com.boolea.oaxaca.model.Gallery
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
            listPlaces.add(Place(1, Zone.CENTER, ctx.getString(R.string.title_centro_historico),
                    listOf(Gallery(R.drawable.zocalo),
                            Gallery(R.drawable.zocalo_1),
                            Gallery(R.drawable.zocalo_2)),
                    ctx.getString(R.string.description_centro_historico), LatLng(17.0605261,
                    -96.7252921)))
            listPlaces.add(Place(2, Zone.CENTER, ctx.getString(R.string.title_templo_sto_domingo),
                    listOf(Gallery(R.drawable.sto_domingo),
                            Gallery(R.drawable.sto_domingo_1),
                            Gallery(R.drawable.sto_domingo_2),
                            Gallery(R.drawable.sto_domingo_3)),
                    ctx.getString(R.string.description_sto_domingo), LatLng(17.06815, -96.713908)))

            listPlaces.add(Place(3, Zone.CENTER, ctx.getString(R.string.title_mertcado_veinte_nov),
                    listOf(Gallery(R.drawable.mercado_veinte_noviembre),
                            Gallery(R.drawable.mco_veinte_1),
                            Gallery(R.drawable.mco_veinte_2),
                            Gallery(R.drawable.mco_veinte_3)
                    ), ctx.getString(R.string.description_mecado_veinte_nov),
                    LatLng(16.999464, -96.722999)))

            listPlaces.add(Place(4, Zone.CENTER, ctx.getString(R.string.title_teatro_macedonio),
                    listOf(Gallery(R.drawable.teatro_macedonio),
                            Gallery(R.drawable.teatro_1),
                            Gallery(R.drawable.teatro_2),
                            Gallery(R.drawable.teatro_3),
                            Gallery(R.drawable.teatro_4)), ctx.getString(R.string.description_teatro_macedonio),
                    LatLng(17.060788, -96.733455)))

            listPlaces.add(Place(5, Zone.CENTER, ctx.getString(R.string.title_calle_macedonio),
                    listOf(Gallery(R.drawable.calle_macedonio),
                            Gallery(R.drawable.c_macedonio_1),
                            Gallery(R.drawable.c_macedonio_2)), ctx.getString(R.string.description_calle_macedonio),
                    LatLng(17.06815, -96.713908)))

            listPlaces.add(Place(6, Zone.CENTER, ctx.getString(R.string.title_mercado_benito_juarez),
                    listOf(Gallery(R.drawable.mercado_benito_juarez),
                            Gallery(R.drawable.m_benito_1),
                            Gallery(R.drawable.m_benito_2),
                            Gallery(R.drawable.m_benito_3)),
                    ctx.getString(R.string.description_mercado_benito_juarez), LatLng(17.060788, -96.733455)))

            listPlaces.add(Place(7, Zone.CENTER, ctx.getString(R.string.title_museo_arte_prehispanico),
                    listOf(Gallery(R.drawable.museo_rafino_prehispanico),
                            Gallery(R.drawable.m_rafino),
                            Gallery(R.drawable.m_rafino_2)
                    ),
                    ctx.getString(R.string.description_museo_arte_prehispanico), LatLng(16.9458, -96.6875)))

            listPlaces.add(Place(8, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_monte_alban),
                    listOf(Gallery(R.drawable.monte_alban),
                            Gallery(R.drawable.monte_alban_1),
                            Gallery(R.drawable.monte_alban_2),
                            Gallery(R.drawable.monte_alban_3)), ctx.getString(R.string.description_monte_alban),
                    LatLng(16.9458, -96.6875)))

            listPlaces.add(Place(9, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_san_antonio_arrazola),
                    listOf(Gallery(R.drawable.sn_antonio_arrazola),
                            Gallery(R.drawable.sn_antonio_1),
                            Gallery(R.drawable.sn_antonio_2),
                            Gallery(R.drawable.sn_antonio_3)),
                    ctx.getString(R.string.description_san_antonio_arrazola),
                    LatLng(17.0333, -96.7833)))

            listPlaces.add(Place(10, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_san_jeronimo),
                    listOf(Gallery(R.drawable.san_jeronimo),
                            Gallery(R.drawable.sn_jeronimo_1),
                            Gallery(R.drawable.sn_jeronimo_2),
                            Gallery(R.drawable.sn_jeronimo_3)),
                    ctx.getString(R.string.description_san_jeronimo),
                    LatLng(17.01568, -96.54082)))

            listPlaces.add(Place(11, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_sta_maria_tule),
                    listOf(Gallery(R.drawable.sta_maria_tule),
                            Gallery(R.drawable.sta_maria_1),
                            Gallery(R.drawable.sta_maria_2),
                            Gallery(R.drawable.sta_maria_3),
                            Gallery(R.drawable.sta_maria_4)
                    ), ctx.getString(R.string.description_sta_maria_tule),
                    LatLng(17.0333, -96.6167)))

            listPlaces.add(Place(12, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_teotitlan),
                    listOf(Gallery(R.drawable.teotitlan),
                            Gallery(R.drawable.teotitlan_1),
                            Gallery(R.drawable.teotitlan_2),
                            Gallery(R.drawable.teotitlan_3)
                    ), ctx.getString(R.string.description_teotitlan_valle),
                    LatLng(17.0333, -96.5)))

            listPlaces.add(Place(13, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_hierve_agua),
                    listOf(Gallery(R.drawable.hieve_agua),
                            Gallery(R.drawable.hieve_agua_1),
                            Gallery(R.drawable.hieve_agua_2)), ctx.getString(R.string.description_hierve_agua),
                    LatLng(16.8658, -96.2768)))

            listPlaces.add(Place(14, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_sn_bartolo),
                    listOf(Gallery(R.drawable.sn_bartolo),
                            Gallery(R.drawable.sn_bartolo_1),
                            Gallery(R.drawable.sn_bartolo_2),
                            Gallery(R.drawable.sn_bartolo_3)
                    ), ctx.getString(R.string.description_sn_bartolo),
                    LatLng(17.55, -97.2833)))

            listPlaces.add(Place(15, Zone.ARCHAEOLOGICAL, ctx.getString(R.string.title_zone_miltla),
                    listOf(Gallery(R.drawable.zona_milta),
                            Gallery(R.drawable.zona_milta_1),
                            Gallery(R.drawable.zona_milta_2),
                            Gallery(R.drawable.zona_milta_3)),
                    ctx.getString(R.string.description_zone_miltla),
                    LatLng(16.9167, -96.4)))

            listPlaces.add(Place(16, Zone.COAST, ctx.getString(R.string.title_huatulco),
                    listOf(Gallery(R.drawable.huatulco),
                            Gallery(R.drawable.huatulco_1),
                            Gallery(R.drawable.huatulco_2)),
                    ctx.getString(R.string.description_huatulco),
                    LatLng(15.75, -96.1333)))

            listPlaces.add(Place(17, Zone.COAST, ctx.getString(R.string.title_puerto_angel),
                    listOf(Gallery(R.drawable.puerto_angel),
                            Gallery(R.drawable.puerto_angel_1),
                            Gallery(R.drawable.puerto_angel_2)),
                    ctx.getString(R.string.description_puerto_angel),
                    LatLng(15.6667, -96.4833)))


            listPlaces.add(Place(18, Zone.COAST,
                    ctx.getString(R.string.title_puerto_escondido),
                    listOf(Gallery(R.drawable.puerto_escondido),
                            Gallery(R.drawable.puerto_escondido_1),
                            Gallery(R.drawable.puerto_escondido_2),
                            Gallery(R.drawable.puerto_escondido_3)),
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