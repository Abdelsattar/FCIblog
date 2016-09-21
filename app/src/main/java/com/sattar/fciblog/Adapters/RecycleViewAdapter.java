package com.sattar.fciblog.Adapters;

/**
 * Created by sattar on 19/09/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sattar.fciblog.Models.Post;
import com.sattar.fciblog.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 20/03/2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Post> posts;
    Context context;
    boolean isProfile;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public RecycleViewAdapter(Context context, ArrayList<Post> posts, boolean isProfile) {
        this.posts = posts;
        this.context = context;
        this.isProfile = isProfile;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        if (viewType == TYPE_HEADER) {
            View view;
            if (isProfile) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_profile, viewGroup, false);

                return new HeaderViewHolder(view);
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_new_post, viewGroup, false);
                return new AddPostViewHolder(view);
            }

        } else {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_post_item, viewGroup, false);
            return new PostViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            if (posts.get(position).getId() != null) {
                headerHolder.userName.setText(posts.get(position).getOwner().getName());
                headerHolder.userEmail.setText(posts.get(position).getOwner().getEmail());
            }
        } else if (holder instanceof AddPostViewHolder) {
            AddPostViewHolder addPostViewHolder = (AddPostViewHolder) holder;
            addPostViewHolder.addPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO here is to add an action to the post Button in Home
                    makePost();
                }
            });
        } else {
            PostViewHolder postViewHolder = (PostViewHolder) holder;
            if (posts.get(position).getId() != null) {
                postViewHolder.userName.setText(posts.get(position).getOwner().getName());
                postViewHolder.postContent.setText(posts.get(position).getOwner().getName());
                postViewHolder.numLikes.setText(posts.get(position).getOwner().getName());
                postViewHolder.timePosted.setText(posts.get(position).getOwner().getName());
            }
        }
    }

    void makePost() {
        Toast.makeText(context, "Posted", Toast.LENGTH_SHORT).show();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView userName;
        TextView userEmail;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.header_profile_pic);
            userName = (TextView) itemView.findViewById(R.id.header_user_name);
            userEmail = (TextView) itemView.findViewById(R.id.header_user_email);
        }
    }

    class AddPostViewHolder extends RecyclerView.ViewHolder {

        EditText postContent;
        Button addPost;

        public AddPostViewHolder(View itemView) {
            super(itemView);
            postContent = (EditText) itemView.findViewById(R.id.add_post_post_content);
            addPost = (Button) itemView.findViewById(R.id.add_post_button);
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
        return posts.size() + 1;
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