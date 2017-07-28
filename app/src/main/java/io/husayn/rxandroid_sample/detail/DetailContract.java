package io.husayn.rxandroid_sample.detail;

import android.content.Intent;

import io.husayn.rxandroid_sample.BasePresenter;
import io.husayn.rxandroid_sample.BaseView;
import io.husayn.rxandroid_sample.model.Post;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public interface DetailContract {

    interface View extends BaseView<Presenter> {

        void getPost();

        void setPost(Post post);

        void onError(String message);
    }

    interface Presenter extends BasePresenter {

        void setView(DetailFragment view);

        void getPost(Intent intent);

        void setPost(Post post);

        void onError(Throwable t);
    }
}
