package com.boolea.oaxaca.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.boolea.oaxaca.R;
import com.boolea.oaxaca.model.Place;
import com.boolea.oaxaca.model.Zone;
import com.boolea.oaxaca.ui.base.BaseActivity;
import com.boolea.oaxaca.ui.places.PlacesFragment;
import com.boolea.oaxaca.ui.places.PlacesOptionsFragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushSingleFragment(new PlacesOptionsFragment(),
                PlacesOptionsFragment.class.getSimpleName(), false);
    }
}
