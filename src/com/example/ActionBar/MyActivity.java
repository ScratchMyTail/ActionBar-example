package com.example.ActionBar;

import android.app.*;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import fragments.FavoritterFragment;
import fragments.TastaturFragment;

public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Create ActionBar
        ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowHomeEnabled(false);

        // Create tabs
        ActionBar.Tab favTab = bar.newTab().setText("Favoritter");
        ActionBar.Tab tastTab = bar.newTab().setText("Tastatur");

        // Create fragments
        FavoritterFragment favoritterFragment = new FavoritterFragment();
        TastaturFragment tastaturFragment = new TastaturFragment();

        // Set tabListener on tabs
        favTab.setTabListener(new MyTabsListener(favoritterFragment, getApplicationContext()));
        tastTab.setTabListener(new MyTabsListener(tastaturFragment, getApplicationContext()));

        // Add tabs to ActionBar
        bar.addTab(favTab);
        bar.addTab(tastTab);
    }

    class MyTabsListener implements ActionBar.TabListener {
        public Fragment fragment;
        public Context context;

        public MyTabsListener(Fragment fragment, Context context) {
            this.fragment = fragment;
            this.context = context;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Reselected!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Selected!", Toast.LENGTH_SHORT).show();
            ft.replace(R.id.fragmentContainer, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(context, "Unselected!", Toast.LENGTH_SHORT).show();
            ft.remove(fragment);
        }
    }
}
