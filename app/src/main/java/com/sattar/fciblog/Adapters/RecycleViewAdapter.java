package com.sattar.fciblog.Adapters;

/**
 * Created by sattar on 19/09/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sattar.fciblog.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 20/03/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<String> Posts;
    Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public RecycleViewAdapter(Context context, ArrayList<String> Posts) {
        this.Posts = Posts;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Log.d("Post Type", viewType + "");
        if (viewType == TYPE_HEADER) {
//            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_profile, viewGroup, false);
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_new_post, viewGroup, false);
            return new HeaderViewHolder(v);
        } else {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_post_item, viewGroup, false);
            return new PostViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String description = "";

//        if (Posts.get(position).getUser_name() != "null" && Posts.get(position).getUser_name() != null) {
//            holder.personName.setText(Posts.get(position).getUser_name());
//            description += Posts.get(position).getUser_name();
//        }
        if (holder instanceof HeaderViewHolder) {
//            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
//            headerHolder.txtTitleHeader.setText ("Header");
//            headerHolder.txtTitleHeader.setOnClickListener (new View.OnClickListener () {
//                @Override
//                public void onClick (View view) {
//                    Toast.makeText (context, "Clicked Header", Toast.LENGTH_SHORT).show ();
//                }
//            });
        } else if (holder instanceof PostViewHolder) {
//            FooterViewHolder footerHolder = (FooterViewHolder) holder;
//            footerHolder.txtTitleFooter.setText ("Footer");
//            footerHolder.txtTitleFooter.setOnClickListener (new View.OnClickListener () {
//                @Override
//                public void onClick (View view) {
//                    Toast.makeText (context, "Clicked Footer", Toast.LENGTH_SHORT).show ();
//                }
//            });
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView userName;
        TextView userEmail;

        public HeaderViewHolder(View itemView) {
            super(itemView);
//            profileImage = (ImageView) itemView.findViewById(R.id.header_profile_pic);
//            userName = (TextView) itemView.findViewById(R.id.header_user_name);
//            userEmail = (TextView) itemView.findViewById(R.id.header_user_email);
        }
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView personPic;
        TextView userName;
        TextView timePosted;
        TextView postContent;
        TextView numLikes;
        ImageButton likeImage;

        PostViewHolder(View itemView) {
            super(itemView);
            personPic = (ImageView) itemView.findViewById(R.id.card_view_profile_image);
            likeImage = (ImageButton) itemView.findViewById(R.id.card_view_like_image_button);
            userName = (TextView) itemView.findViewById(R.id.card_view_user_name);
            timePosted = (TextView) itemView.findViewById(R.id.card_view_time_posted);
            postContent = (TextView) itemView.findViewById(R.id.card_view_post_content);
            numLikes = (TextView) itemView.findViewById(R.id.card_view_num_likes);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return Posts.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}