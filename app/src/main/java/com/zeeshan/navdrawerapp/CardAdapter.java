package com.zeeshan.navdrawerapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zeeshan on 9/19/2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private LayoutInflater inflater;
    List<CardInfo> data = Collections.emptyList();

    public CardAdapter(List<CardInfo> data) {

        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cardText;
        ImageView cardImage;

        public ViewHolder(View itemView) {
            super(itemView);

            cardText = (TextView) itemView.findViewById(R.id.card_name);
            cardImage = (ImageView) itemView.findViewById(R.id.card_image);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card, parent, false);

        ViewHolder vi = new ViewHolder(v);
        return vi;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardInfo current = data.get(position);
        holder.cardText.setText(current.title);
        holder.cardImage.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}