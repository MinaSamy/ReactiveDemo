package net.minasamy.reactiveprogrammingdemo.model;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class ObservableFactory {

    static public Observable<Integer> createObservable(DemoItem.DemoItemType itemType) {
        switch (itemType) {
            case BASIC_OBSERVABLE:
            default: {
                return Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        for (int i = 0; i < 5; i++){
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                });
            }
        }
    }
}
