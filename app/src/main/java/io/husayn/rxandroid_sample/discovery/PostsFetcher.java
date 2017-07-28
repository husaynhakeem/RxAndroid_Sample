package io.husayn.rxandroid_sample.discovery;

import io.husayn.rxandroid_sample.network.Api;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class PostsFetcher {

    public void loadPosts(PostsPresenter presenter) {
        Api.instance()
                .apiInterface()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::setPosts, presenter::onError);
    }
}
