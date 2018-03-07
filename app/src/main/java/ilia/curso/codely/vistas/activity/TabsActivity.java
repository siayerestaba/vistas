package ilia.curso.codely.vistas.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ilia.curso.codely.vistas.R;
import ilia.curso.codely.vistas.fragments.RecyclerFragment;
import ilia.curso.codely.vistas.fragments.WebViewFragment;

/**
 * Created by leli on 07/03/2018.
 */

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Cursos"));
        tabs.addTab(tabs.newTab().setText("Web"));

        ViewPager vpPager = findViewById(R.id.card_pager);
        TabsPagerAdapter adapterViewPager = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        tabs.setupWithViewPager(vpPager);
    }


    public class TabsPagerAdapter extends FragmentPagerAdapter {
        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            switch (index) {
                case 0:
                    RecyclerFragment recyclerFrg = new RecyclerFragment();
                    return recyclerFrg;
                case 1:
                    WebViewFragment webviewFrg = new WebViewFragment();
                    return webviewFrg;
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Cursos";
                case 1:
                    return "Web";
            }

            return "";
        }

        @Override
        public int getCount() {
            // get item count - equal to number of slides
            return 2;
        }
    }
}
