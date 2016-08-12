package net.minasamy.reactiveprogrammingdemo.model;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class ObservableFactory {

    public static <T extends Object> Observable<T> createObservable(DemoItem.DemoItemType itemType) {
        switch (itemType) {
            case BASIC_OBSERVABLE:
            default: {
                return (Observable<T>) Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        for (int i = 0; i < 10; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                });
            }
            case OBSERVABLE_FROM: {
                return (Observable<T>) Observable.from(getItems());
            }
            case OBSERVABLE_JUST: {
                return (Observable<T>) Observable.just(getItems());
            }
        }
    }

    /**
     * An Observable created from Observable.just() can be created
     * with this method
     *
     * @return a list of integers
     */
    private static List<Integer> getItems() {
        List<Integer> items = new ArrayList<Integer>() {
            {
                add(0);
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        return items;
    }
}
