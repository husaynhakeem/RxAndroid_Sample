package io.husayn.rxandroid_sample.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.rxandroid_sample.R;
import io.husayn.rxandroid_sample.model.Post;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class DetailFragment extends Fragment implements DetailContract.View {


    @BindView(R.id.tv_detail_title)
    TextView titleTextView;
    @BindView(R.id.tv_detail_body)
    TextView bodyTextView;
    private DetailPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        getPost();
        return view;
    }


    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        this.presenter = (DetailPresenter) presenter;
    }


    @Override
    public void getPost() {
        presenter.getPost(getActivity().getIntent());
    }


    @Override
    public void setPost(Post post) {
        titleTextView.setText(post.getTitle());
        bodyTextView.setText(post.getBody());
    }


    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), "Error while loading the detail: " + message, Toast.LENGTH_SHORT).show();
    }
}
