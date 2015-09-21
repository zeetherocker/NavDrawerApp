package com.zap.Kalanjali;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Zeeshan on 9/21/2015.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private String mText;
    private String[] mItemList;

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER =2;

    public EventAdapter(String[] mTitles) {
        mItemList = mTitles;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(context).inflate(R.layout.event_recycler_view, parent, false);
            return ViewHolder.newInstance(view);
        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(context).inflate(R.layout.event_recycler_header, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder viewholder, int position) {
        if (!isPositionHeader(position)) {
            ViewHolder holder = (ViewHolder) viewholder;
            String cText = mItemList[position - 1];
            holder.setText(cText);
        }
    }

    @Override
    public int getItemCount() {
        int count = mItemList == null ? 0: mItemList.length;
        return count+1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mDescTextView;

        public ViewHolder(final View itemView, TextView mTextView) {
            super(itemView);
            mDescTextView = mTextView;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public static ViewHolder newInstance(View itemView) {
            TextView mTextView = (TextView) itemView.findViewById(R.id.event_recycler_text);
            return new ViewHolder(itemView, mTextView);
        }

        public void setText (CharSequence text) {

            mDescTextView.setText(text);
        }
    }

    //added a method that returns viewType for a given position
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    //added a method to check if given position is a header
    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
