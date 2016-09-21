package com.sattar.fciblog.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sattar.fciblog.Adapters.RecycleViewAdapter;
import com.sattar.fciblog.Models.Post;
import com.sattar.fciblog.R;

import java.util.ArrayList;


/**
 * Created by sattar on 19/09/16.
 */
public class ProfileFragment extends Fragment {

    private ArrayList<Post> posts;
    private View currentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_with_recycler_view, container, false);
        posts = new ArrayList<>();
        this.currentView = view;
        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {

        RecyclerView recycleView =
                (RecyclerView) currentView.findViewById(R.id.recycle_view);
        recycleView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycleView.setLayoutManager(layoutManager);

        //TODO replace posts withe real data
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        RecycleViewAdapter recyclerViewAdapter
                = new RecycleViewAdapter(getContext(), posts, true);

        recycleView.setAdapter(recyclerViewAdapter);
    }
}
