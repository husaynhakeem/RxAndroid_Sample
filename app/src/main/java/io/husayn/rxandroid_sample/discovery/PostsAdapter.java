package io.husayn.rxandroid_sample.discovery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.husayn.rxandroid_sample.R;
import io.husayn.rxandroid_sample.model.Post;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostHolder> {


    private List<Post> posts;
    private PostClickListener postClickListener;


    public PostsAdapter(List<Post> posts, PostClickListener postClickListener) {
        this.posts = posts;
        this.postClickListener = postClickListener;
    }


    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PostHolder holder, final int position) {
        Post post = posts.get(position);
        holder.titleTextView.setText(post.getTitle());
        holder.bodyTextView.setText(post.getBody());
        holder.itemView.setOnClickListener(view -> postClickListener.onClick(post.getId()));
    }


    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }


    interface PostClickListener {
        void onClick(int postId);
    }
}
