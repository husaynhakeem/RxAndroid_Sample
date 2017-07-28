package io.husayn.rxandroid_sample.detail;

import android.content.Intent;
import android.util.Log;

import io.husayn.rxandroid_sample.model.Post;

import static io.husayn.rxandroid_sample.model.Post.POST_ID;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private static final int DEFAULT_POST_ID = -1;
    private DetailFragment view;


    @Override
    public void start() {
    }


    @Override
    public void setView(DetailFragment view) {
        this.view = view;
    }


    @Override
    public void getPost(Intent intent) {
        int postId = intent.getIntExtra(POST_ID, DEFAULT_POST_ID);
        DetailFetcher fetcher = new DetailFetcher();
        fetcher.loadDetail(this, postId);
    }


    @Override
    public void setPost(Post post) {
        view.setPost(post);
    }


    @Override
    public void onError(Throwable t) {
        view.onError(t.getMessage());
        Log.e("Detail presenter", t.getMessage());
    }
}
