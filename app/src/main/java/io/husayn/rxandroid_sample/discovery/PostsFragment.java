package io.husayn.rxandroid_sample.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.rxandroid_sample.R;
import io.husayn.rxandroid_sample.model.Post;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class PostsFragment extends Fragment implements PostsContract.View, PostsAdapter.PostClickListener {


    @BindView(R.id.rv_posts)
    RecyclerView postsRecyclerView;
    PostsAdapter postsAdapter;
    PostsPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void setPresenter(PostsContract.Presenter presenter) {
        this.presenter = (PostsPresenter) presenter;
    }


    @Override
    public void setPosts(List<Post> posts) {
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postsAdapter = new PostsAdapter(posts, this);
        postsRecyclerView.setAdapter(postsAdapter);
    }


    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), "Error while loading the posts: " + message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(int postId) {
        presenter.onPostClicked(getContext(), postId);
    }
}
