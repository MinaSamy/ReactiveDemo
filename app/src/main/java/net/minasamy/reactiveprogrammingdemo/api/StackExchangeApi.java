package net.minasamy.reactiveprogrammingdemo.api;

import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Mina.Samy on 9/18/2016.
 */
public interface StackExchangeApi {
    String BASE_URL = "https://api.stackexchange.com/2.2/";

    @GET("users?order=desc&sort=reputation&site=stackoverflow&page=1&pagesize=3")
    Observable<List<StackExchangeUser>> getTopContributers();
}
