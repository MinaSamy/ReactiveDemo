package net.minasamy.reactiveprogrammingdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
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
            case BEHAVIOR_SUBJECT: {
                BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("1");
                behaviorSubject.onNext("2");
                behaviorSubject.onNext("3");
                behaviorSubject.onNext("4");
                return (Observable<T>) behaviorSubject;
            }
            case REPLAY_SUBJECT: {
                ReplaySubject<Integer> replaySubject = ReplaySubject.create();
                for (int i : getItems()) {
                    replaySubject.onNext(i);
                }
                return (Observable<T>) replaySubject;
            }
            case ASYNC_SUBJECT: {
                AsyncSubject<Integer> asyncSubject = AsyncSubject.create();
                for (int i : getItems()) {
                    asyncSubject.onNext(i);
                }
                asyncSubject.onCompleted();
                return (Observable<T>) asyncSubject;
            }
            case REPEAT: {
                return (Observable<T>) Observable.from(getItems())
                        .repeat(2);
            }
            case DEFER: {
                return (Observable<T>) Observable.defer(new Func0<Observable<T>>() {
                    @Override
                    public Observable<T> call() {
                        return getItemsObservable();
                    }
                });
            }
            case RANGE: {
                return (Observable<T>) Observable.range(5, 3);
            }
            case INTERVAL: {
                return (Observable<T>) Observable.interval(3, TimeUnit.SECONDS);
            }
            case TIMER: {
                return (Observable<T>) Observable.timer(3, TimeUnit.SECONDS);
            }
            case FILTER: {
                return (Observable<T>) Observable.from(getItems()).filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        if (integer % 2 == 0) {
                            return true;
                        }
                        return false;
                    }
                });
            }
            case TAKE: {
                return (Observable<T>) Observable.from(getItems()).take(2);
            }
            case TAKE_LAST: {
                return (Observable<T>) Observable.from(getItems()).takeLast(2);
            }
            case DISTINCT: {
                return (Observable<T>) Observable.from(getDuplicates()).distinct();
            }
            case DISTINCT_UNTIL_CHANGED: {
                return (Observable<T>) Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(0);
                        subscriber.onNext(0);
                        subscriber.onNext(0);
                        subscriber.onNext(0);
                        subscriber.onNext(1);
                        subscriber.onNext(2);
                        subscriber.onNext(2);
                    }
                }).distinctUntilChanged();
            }
            case FIRST: {
                return (Observable<T>) Observable.from(getItems()).first();
            }
            case LAST: {
                return (Observable<T>) Observable.from(getItems()).last();
            }
            case SKIP: {
                return (Observable<T>) Observable.from(getItems()).skip(2);
            }
            case SKIP_LAST: {
                return (Observable<T>) Observable.from(getItems()).skipLast(2);
            }
            case SAMPLE:{
                Observable itemsObservable=Observable.interval(3,TimeUnit.SECONDS);
                Observable sampleObservable=itemsObservable.sample(5,TimeUnit.SECONDS);
                return sampleObservable;
            }
            case THROTTLE_FIRST:{
                Observable itemsObservable=Observable.interval(1,TimeUnit.SECONDS);
                Observable sampleObservable=itemsObservable.throttleFirst(5,TimeUnit.SECONDS);
                return sampleObservable;
            }
            case THROTTLE_LAST:{
                Observable itemsObservable=Observable.interval(1,TimeUnit.SECONDS);
                Observable sampleObservable=itemsObservable.throttleLast(5,TimeUnit.SECONDS);
                return sampleObservable;
            }
            case MAP:{
                return (Observable<T>) Observable.from(getItems()).map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer item) {
                        return item*2;
                    }
                });
            }
            case FLAT_MAP:{
                //instead of making the subscriber receive the whole list, we'll flat map it so that the
                //subscriber receives item by item, converting observable.just() to observable.from()
                return (Observable<T>) getStringList().flatMap(new Func1<List<String>, Observable<?>>() {
                    @Override
                    public Observable<?> call(List<String> strings) {
                        return Observable.from(strings);
                    }
                });
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

    private static Observable getItemsObservable() {
        return Observable.from(getItems());
    }

    private static List<Integer> getDuplicates() {
        List<Integer> items = new ArrayList<Integer>() {
            {
                add(0);
                add(0);
                add(0);
                add(1);
                add(1);
                add(1);
                add(2);
                add(2);
                add(3);
                add(3);
                add(3);
                add(4);
                add(4);
                add(5);
                add(5);
            }
        };
        return items;
    }

    private static Observable<List<String>>getStringList(){
        List<String>items=new ArrayList<>();
        for(char i='A';i<='E';i++){
            items.add(String.valueOf(i));
        }
        //subscriber recieves the whole list
        return Observable.just(items);
    }
}
