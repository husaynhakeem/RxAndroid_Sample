package io.husayn.rxandroid_sample.discovery;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import io.husayn.rxandroid_sample.detail.DetailActivity;
import io.husayn.rxandroid_sample.model.Post;

import static io.husayn.rxandroid_sample.model.Post.POST_ID;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class PostsPresenter implements PostsContract.Presenter {


    private PostsFragment view;


    public void setView(PostsFragment view) {
        this.view = view;
    }


    @Override
    public void start() {
       loadPosts();
    }


    @Override
    public void loadPosts() {
        PostsFetcher fetcher = new PostsFetcher();
        fetcher.loadPosts(this);
    }


    @Override
    public void setPosts(List<Post> posts) {
        view.setPosts(posts);
    }


    @Override
    public void onPostClicked(Context context, int postId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(POST_ID, postId);
        context.startActivity(intent);
    }


    @Override
    public void onError(Throwable t) {
        view.onError(t.getMessage());
        Log.e("Posts Presenter", t.getMessage());
    }
}
