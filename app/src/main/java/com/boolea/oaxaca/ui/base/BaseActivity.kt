package com.boolea.oaxaca.ui.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

import com.boolea.oaxaca.R

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
 * operez@na-at.com.mx
 */
open class BaseActivity : AppCompatActivity() {


    fun pushSingleFragment(fragment: android.support.v4.app.Fragment, tag: String, addBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
                R.anim.push_left_in, R.anim.push_left_out, R.anim.push_left_in, R.anim.push_left_out)
        transaction.replace(R.id.frame_content, fragment, tag)
        if (addBackStack)
            transaction.addToBackStack(tag)
        try {
            transaction.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
