package com.boolea.oaxaca.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.boolea.oaxaca.R;

/**
 * Created by Oscar Emilio Pérez Mtz on 25/11/2018.
 * operez@na-at.com.mx
 */
public class BaseActivity extends AppCompatActivity {


    public void pushSingleFragment(Fragment fragment, String tag, boolean addBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                R.anim.push_left_in, R.anim.push_left_out, R.anim.push_left_in, R.anim.push_left_out);
        transaction.replace(R.id.frame_content, fragment, tag);
        if (addBackStack)
            transaction.addToBackStack(tag);
        try {
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
