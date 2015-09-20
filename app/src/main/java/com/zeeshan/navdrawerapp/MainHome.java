package com.zeeshan.navdrawerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class MainHome extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_main_event, container, false);
        myView.isClickable();
        myView.setOnClickListener(mClickListner);
        return myView;
    }

    private View.OnClickListener mClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), EventActivity.class));
        }
    };
}
