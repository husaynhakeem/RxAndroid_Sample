package io.husayn.rxandroid_sample.discovery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.husayn.rxandroid_sample.R;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public class PostHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tv_post_title)
    TextView titleTextView;

    @BindView(R.id.tv_post_body)
    TextView bodyTextView;

    public PostHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
