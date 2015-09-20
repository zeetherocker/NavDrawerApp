package com.zap.Kalanjali;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeeshan on 9/15/2015.
 */
public class FirstFragment extends Fragment {

    View myView;
    CardAdapter cardAdapter;
    RecyclerView cardView;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_first, container, false);

        cardView = (RecyclerView) myView.findViewById(R.id.card_list);
        cardAdapter = new CardAdapter(getData());
        cardView.setAdapter(cardAdapter);
        cardView.setLayoutManager(new LinearLayoutManager(getActivity()));

        layoutManager = new LinearLayoutManager(getActivity());                 // Creating a layout Manager

        cardView.setLayoutManager(layoutManager);
        return myView;
    }

    public static List<CardInfo> getData() {
        List<CardInfo> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_card1, R.drawable.ic_card2};
        String[] titles = {"Event 1" ,"Event 2"};
        for(int i=0; i<icons.length && i<titles.length; i++){
            CardInfo current = new CardInfo();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }
}
