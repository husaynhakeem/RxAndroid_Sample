package io.husayn.rxandroid_sample.detail;

import io.husayn.rxandroid_sample.network.Api;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class DetailFetcher {


    public void loadDetail(DetailPresenter presenter, int postId) {

        Api.instance()
                .apiInterface()
                .getPost(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::setPost, presenter::onError);
    }
}
