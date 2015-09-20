package com.zap.Kalanjali;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class HomeActivity extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_activity_main, container, false);
        ScrollView v = (ScrollView) myView.findViewById(R.id.scroll_view);
        v.post(new Runnable() {
            @Override
            public void run() {
                ((ScrollView) myView.findViewById(R.id.scroll_view)).fullScroll(View.FOCUS_UP);
                ((ScrollView) myView.findViewById(R.id.scroll_view)).setFocusable(false);

            }
        });
        return myView;
    }
}
