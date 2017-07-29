package com.example.toshiba.airbnb.Explore;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toshiba.airbnb.R;


/**
 * Created by Owner on 2017-06-25.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {
    Context mContext;

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_adapter, parent, false);
        mContext = parent.getContext();
        SectionViewHolder SectionViewHolder = new SectionViewHolder(view);
        return SectionViewHolder;
    }

    @Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        holder.bindView(position);
        SingleContentAdapter singleContentAdapter = new SingleContentAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        holder.singleContentRecyclerView.setLayoutManager(layoutManager);
        holder.singleContentRecyclerView.setAdapter(singleContentAdapter);
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder {
        RecyclerView singleContentRecyclerView;
        TextView textView;

        public SectionViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvSection);
            singleContentRecyclerView = (RecyclerView) itemView.findViewById(R.id.singleContentRecyclerView);
        }

        public void bindView(int position) {
            if (position == 1)
                textView.setText("Hey");
        }
    }
}
