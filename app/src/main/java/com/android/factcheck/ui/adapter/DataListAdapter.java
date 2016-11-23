package com.android.factcheck.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.factcheck.R;
import com.android.factcheck.model.FeedDataModel;

import java.util.List;

/**
 * Created by divyanshunegi on 11/23/16.
 * Project : FactCheck
 */
public class DataListAdapter  extends RecyclerView.Adapter<DataListAdapter.MyViewHolder> {

    private List<FeedDataModel> mFeedData;

    public DataListAdapter(List<FeedDataModel> mFeedData) {
        this.mFeedData = mFeedData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_dashboard_post, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeedDataModel feedDataModel = mFeedData.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return mFeedData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }


}
