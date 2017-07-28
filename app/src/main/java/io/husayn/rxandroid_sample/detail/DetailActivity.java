package io.husayn.rxandroid_sample.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.husayn.rxandroid_sample.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detailFragment = new DetailFragment();
        DetailPresenter detailPresenter = new DetailPresenter();

        detailFragment.setPresenter(detailPresenter);
        detailPresenter.setView(detailFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_frame, detailFragment)
                .commit();
    }
}
