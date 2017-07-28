package io.husayn.rxandroid_sample.discovery;

import android.content.Context;

import java.util.List;

import io.husayn.rxandroid_sample.BasePresenter;
import io.husayn.rxandroid_sample.BaseView;
import io.husayn.rxandroid_sample.model.Post;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public interface PostsContract {

    interface View extends BaseView<Presenter> {

        void setPosts(List<Post> posts);

        void onError(String message);
    }

    interface Presenter extends BasePresenter {

        void loadPosts();

        void setPosts(List<Post> posts);

        void onPostClicked(Context context, int postId);

        void onError(Throwable t);
    }
}
