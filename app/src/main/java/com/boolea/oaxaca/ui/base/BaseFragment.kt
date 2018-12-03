package com.boolea.oaxaca.ui.base

import android.support.v4.app.Fragment

/**
 * Created by Oscar Emilio Pérez Mtz on 02/12/2018.
operez@na-at.com.mx
 */
open class BaseFragment : Fragment() {
    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}