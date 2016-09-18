package net.minasamy.reactiveprogrammingdemo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import net.minasamy.reactiveprogrammingdemo.api.StackExchangeApi;
import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;
import net.minasamy.reactiveprogrammingdemo.util.StackExchangeUserDeserializer;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Mina.Samy on 9/18/2016.
 */
public class StackExchangeService {

    private StackExchangeApi mStackExchangeApi;

    public StackExchangeService() {
        Type arrayType=new TypeToken<List<StackExchangeUser>>(){}.getType();
        Gson gson=new GsonBuilder()
                .registerTypeAdapter(arrayType,new StackExchangeUserDeserializer())
                .create();

        RxJavaCallAdapterFactory rxAdapter=RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        Retrofit retrofit = new Retrofit.Builder().baseUrl(StackExchangeApi.BASE_URL)
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mStackExchangeApi=retrofit.create(StackExchangeApi.class);
    }

    public StackExchangeApi getStackExchangeApi() {
        return mStackExchangeApi;
    }
}
