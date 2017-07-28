package io.husayn.rxandroid_sample.network;

import java.util.List;

import io.husayn.rxandroid_sample.model.Post;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by husaynhakeem on 7/28/17.
 */

public interface ApiInterface {

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") int id);

    @GET("/posts")
    Observable<List<Post>> getPosts();
}
