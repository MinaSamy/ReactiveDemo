package net.minasamy.reactiveprogrammingdemo.model;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class ObservableFactory {

    public static <T extends Object> Observable<T> createObservable(ObservableConcept.ConceptType itemType) {
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
            case PUBLISH_SUBJECT: {
                PublishSubject<String> publishSubject = PublishSubject.create();
                return (Observable<T>) publishSubject;
            }
            case BEHAVIOR_SUBJECT:{
                BehaviorSubject<String> behaviorSubject=BehaviorSubject.create("1");
                behaviorSubject.onNext("2");
                behaviorSubject.onNext("3");
                behaviorSubject.onNext("4");
                return (Observable<T>) behaviorSubject;
            }
            case REPLAY_SUBJECT:{
                ReplaySubject<Integer>replaySubject=ReplaySubject.create();
                for(int i:getItems()){
                    replaySubject.onNext(i);
                }
                return (Observable<T>) replaySubject;
            }
            case ASYNC_SUBJECT:{
                AsyncSubject<Integer> asyncSubject=AsyncSubject.create();
                for(int i:getItems()){
                    asyncSubject.onNext(i);
                }
                asyncSubject.onCompleted();
                return (Observable<T>) asyncSubject;
            }
            case REPEAT:{
                return (Observable<T>) Observable.from(getItems())
                        .repeat(2);
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
