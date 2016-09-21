package com.sattar.fciblog.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
public class HomeFragment extends Fragment {
    private ArrayList<Post> posts;
    private View currentView;


    FloatingActionButton addPost;

    RecyclerView recycleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_with_recycler_view, container, false);
        this.currentView = view;
        initScreen();

        return view;
    }

    void initScreen() {
        addPost = (FloatingActionButton) currentView.findViewById(R.id.floatAction);
         addPost.setVisibility(View.VISIBLE);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO this is an action for float action button in home fragment
                recycleView.getLayoutManager().scrollToPosition(0);
            }
        });

        posts = new ArrayList<>();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recycleView =
                (RecyclerView) currentView.findViewById(R.id.recycle_view);
        recycleView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycleView.setLayoutManager(layoutManager);

        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());
        posts.add(new Post());

        RecycleViewAdapter recyclerViewAdapter
                = new RecycleViewAdapter(getContext(), posts, false);

        recycleView.setAdapter(recyclerViewAdapter);

    }
}
