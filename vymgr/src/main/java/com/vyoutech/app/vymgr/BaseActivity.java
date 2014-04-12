package com.vyoutech.app.vymgr;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;

import com.vyoutech.app.vymgr.utils.UIUtils;

/**
 * Created by loulis on 2014/4/12.
 */
public class BaseActivity extends ActionBarActivity
{

    protected void setHasTabs() {
        if (!UIUtils.isTablet(this)
                && getResources().getConfiguration().orientation
                != Configuration.ORIENTATION_LANDSCAPE) {
            // Only show the tab bar's shadow
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(
                    R.drawable.actionbar_background_noshadow));
        }
    }
}
