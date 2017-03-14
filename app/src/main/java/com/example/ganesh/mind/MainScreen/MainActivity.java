package com.example.ganesh.mind.MainScreen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ganesh.mind.Bookmark.BookmarkFragment;
import com.example.ganesh.mind.Discover.DiscoverFragment;
import com.example.ganesh.mind.Home.AddCardDialogFragment;
import com.example.ganesh.mind.Home.HomeFragment;
import com.example.ganesh.mind.Profile.ProfileFragment;
import com.example.ganesh.mind.R;

import static com.example.ganesh.mind.R.id.viewpager;

public class MainActivity extends BaseActivity {
    private String apptitle = "Mind";
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.home_selected,
            R.drawable.ic_explore_black_24dp,
            R.drawable.ic_bookmark_border_black_24dp,
            R.drawable.ic_person_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeScreen();

    }

    private void initializeScreen() {
        viewPager = (ViewPager) findViewById(viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_host);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        toolbar.setTitle(R.string.pager_title_home);
                        break;
                    case 1:
                        toolbar.setTitle(R.string.pager_title_discover);
                        break;
                    case 2:
                        toolbar.setTitle(R.string.pager_title_bookmark);
                        break;
                    case 3:
                        toolbar.setTitle(R.string.pager_title_profile);
                        break;
                    default:
                        toolbar.setTitle(R.string.pager_title_home);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }//oncreate

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    public void showAddCardDialog(View view) {
        /* Create an instance of the dialog fragment and show it */
        DialogFragment dialog = AddCardDialogFragment.newInstance();
        dialog.show(MainActivity.this.getSupportFragmentManager(), "AddCardDialogFragment");
    }



    public class SectionPagerAdapter extends FragmentStatePagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = HomeFragment.newInstance();
                    break;
                case 1:
                    fragment = DiscoverFragment.newInstance();
                    break;
                case 2:
                    fragment = BookmarkFragment.newInstace();
                    break;
                case 3:
                    fragment = ProfileFragment.newInstance();
                    break;
                default:
                    fragment = HomeFragment.newInstance();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {

            return 4;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            return null;
        }
    }
}


