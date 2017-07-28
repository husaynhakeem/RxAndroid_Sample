package io.husayn.rxandroid_sample.discovery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.husayn.rxandroid_sample.R;

public class PostsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        PostsFragment postsFragment = new PostsFragment();
        PostsPresenter postsPresenter = new PostsPresenter();

        postsFragment.setPresenter(postsPresenter);
        postsPresenter.setView(postsFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.posts_frame, postsFragment)
                .commit();
    }
}
