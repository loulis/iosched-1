package com.vyoutech.app.vymgr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.vyoutech.app.vymgr.ui.InfoFragment;
import com.vyoutech.app.vymgr.ui.MeFragment;
import com.vyoutech.app.vymgr.ui.StatisFragment;

import static com.vyoutech.app.vymgr.utils.LogUtils.LOGD;

public class MainActivity extends BaseActivity implements
        ActionBar.TabListener,
        ViewPager.OnPageChangeListener
{

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建viewpager
        FragmentManager fm = getSupportFragmentManager();
        mViewPager = (ViewPager) findViewById(R.id.pager);
        if (mViewPager != null)
        {
            // Phone setup
            mViewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
            mViewPager.setOnPageChangeListener(this);
            //设置页面之间的Margin，以及margin内的填充物
            //            mViewPager.setPageMarginDrawable(R.drawable.grey_border_inset_lr);
            //            mViewPager.setPageMargin(getResources()
            //                    .getDimensionPixelSize(R.dimen.page_margin_width));
        }

        //定义滑动tab
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_statis)
                .setTabListener(this));

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_info)
                .setTabListener(this));

        actionBar.addTab(actionBar.newTab()
                .setText(R.string.tab_me)
                .setTabListener(this));

        //        setHasTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle presses on the action bar items
        switch (item.getItemId())
        {
            case R.id.action_search:
                //                openSearch();
                return true;
            case R.id.action_settings:
                //                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Pager viewer的适配器
     */
    private class HomePagerAdapter extends FragmentPagerAdapter
    {
        public HomePagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    return new StatisFragment();

                case 1:
                    return new InfoFragment();

                case 2:
                    return new MeFragment();
            }
            return null;
        }

        @Override
        public int getCount()
        {
            return 3;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        getSupportActionBar().setSelectedNavigationItem(position);

        int titleId = -1;
        switch (position)
        {
            case 0:
                titleId = R.string.tab_statis;
                break;
            case 1:
                titleId = R.string.tab_info;
                break;
            case 2:
                titleId = R.string.tab_me;
                break;
        }

        String title = getString(titleId);
        LOGD("Tracker", title);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {

    }
}
