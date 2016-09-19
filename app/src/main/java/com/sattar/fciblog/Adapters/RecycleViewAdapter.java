package com.sattar.fciblog.Adapters;

/**
 * Created by sattar on 19/09/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sattar.fciblog.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 20/03/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.PlaceViewHolder> {

    ArrayList<String> Posts;
    Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public RecycleViewAdapter(Context context,  ArrayList<String> Posts) {
        this.Posts = Posts;
        this.context = context;

    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_post_item, viewGroup, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(v);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, final int position) {
        String description = "";

//        if (Posts.get(position).getUser_name() != "null" && Posts.get(position).getUser_name() != null) {
//            holder.personName.setText(Posts.get(position).getUser_name());
//            description += Posts.get(position).getUser_name();
//        }

    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView personPic;

        PlaceViewHolder(View itemView) {
            super(itemView);
            personPic = (ImageView) itemView.findViewById(R.id.header_profile_pic);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }
}