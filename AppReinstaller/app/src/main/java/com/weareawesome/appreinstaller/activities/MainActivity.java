package com.weareawesome.appreinstaller.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.weareawesome.appreinstaller.R;
import com.weareawesome.appreinstaller.fragments.AppDetailsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_activity_root_layout, new AppDetailsFragment(), AppDetailsFragment.TAG);
        fragmentTransaction.commit();
    }
}
