package com.boolea.oaxaca.model

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
operez@na-at.com.mx
 */
enum class Zone {
    CENTER {
        override fun toString(): String {
            return "CENTRO"
        }
    },
    ARCHAEOLOGICAL, COAST
}