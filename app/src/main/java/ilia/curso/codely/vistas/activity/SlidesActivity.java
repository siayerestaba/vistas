package ilia.curso.codely.vistas.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ilia.curso.codely.vistas.R;
import ilia.curso.codely.vistas.fragments.ImageViewFragment;

/**
 * Created by leli on 07/03/2018.
 */

public class SlidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        ViewPager vpPager = findViewById(R.id.card_pager);
        TabsPagerAdapter adapterViewPager = new TabsPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }


    public class TabsPagerAdapter extends FragmentPagerAdapter {
        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int index) {
            int id = getResources().getIdentifier("codely_" + index, "mipmap", getPackageName());

            ImageViewFragment imageFrg = new ImageViewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("idImage", id);
            imageFrg.setArguments(bundle);

            return imageFrg;
        }

        @Override
        public int getCount() {
            // get item count - equal to number of slides
            return 15;
        }
    }
}
