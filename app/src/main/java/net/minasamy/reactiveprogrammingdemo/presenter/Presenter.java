package net.minasamy.reactiveprogrammingdemo.presenter;

/**
 * Created by Mina Samy on 8/6/2016.
 */
public interface Presenter<T> {
    void deliverResult(T result);
}
