package com.vyoutech.app.vymgr.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vyoutech.app.vymgr.R;


/**
 * Created by loulis on 2014/4/12.
 */
public class StatisFragment extends ListFragment
{
    private View mEmptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_list_with_empty_container, container, false);
        mEmptyView = rootView.findViewById(android.R.id.empty);
        inflater.inflate(R.layout.empty_waiting_for_sync, (ViewGroup) mEmptyView, true);
        return rootView;
    }
}
