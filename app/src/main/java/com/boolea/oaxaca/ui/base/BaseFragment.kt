package com.boolea.oaxaca.ui.base

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by Oscar Emilio Pérez Mtz on 02/12/2018.
operez@na-at.com.mx
 */
open class BaseFragment : Fragment() {
    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }

    fun showToast(message: String) {
        Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
    }
}