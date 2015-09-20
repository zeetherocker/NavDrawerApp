package com.zap.Kalanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class FirstHome extends Fragment {

    private String[] listtitles = {"Event-1", "Event-2", "Event-3"};
    private int[] listicons= {R.drawable.ic_card1, R.drawable.ic_card2, R.drawable.ic_card1};

    List<CardInfo> dataCurrent = getData();

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.card_list, container, false);
        populateList();
        registerClick();
        return myView;
    }

    public void populateList() {

        ArrayAdapter<CardInfo> adapter = new MyAdapter();
        ListView listView = (ListView) myView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private void registerClick() {
        ListView list = (ListView) myView.findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), EventActivity.class));
            }
        });
    }

    public List<CardInfo> getData() {
        List<CardInfo> data = new ArrayList<>();
        for (int i=0; i<listtitles.length && i<listicons.length; i++) {
            CardInfo current = new CardInfo();
            current.title = listtitles[i];
            current.iconId = listicons[i];
            data.add(current);
        }
        return data;
    }

    private class MyAdapter extends ArrayAdapter<CardInfo> {

        public MyAdapter() {
            super(getActivity(), R.layout.card_list_item, dataCurrent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null)
                itemView = getActivity().getLayoutInflater().inflate(R.layout.card_list_item, parent, false);

            CardInfo currentCard = dataCurrent.get(position);

            TextView titleView = (TextView) myView.findViewById(R.id.card_list_label);
            titleView.setText("Music Events");
            titleView.isClickable();
            ImageView imageView = (ImageView) itemView.findViewById(R.id.card_image);
            TextView textView = (TextView) itemView.findViewById(R.id.card_item);
            imageView.setImageResource(currentCard.iconId);
            imageView.setOnClickListener(null);
            textView.setText(currentCard.title);

            return itemView;
        }
    }
}
