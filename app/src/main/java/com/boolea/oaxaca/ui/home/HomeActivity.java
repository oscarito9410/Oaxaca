package com.boolea.oaxaca.ui.home;

import android.os.Bundle;

import com.boolea.oaxaca.R;
import com.boolea.oaxaca.ui.base.BaseActivity;
import com.boolea.oaxaca.ui.home.PlacesOptionsFragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushSingleFragment(new PlacesOptionsFragment(),
                PlacesOptionsFragment.class.getSimpleName(), false);
    }
}
