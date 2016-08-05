package net.minasamy.reactiveprogrammingdemo.model;

import net.minasamy.reactiveprogrammingdemo.presenter.Presenter;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class BasicObservableCommand implements ReactiveDemoCommand {

    private Presenter mPresenter;
    @Override
    public void setReceiverPresenter(Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void execute() {
        Observable<Integer> observableInteger=Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for(int i=0;i<5;i++){
                    subscriber.onNext(i);

                }

                subscriber.onCompleted();
                subscriber.unsubscribe();
            }
        });

        Subscription sub= observableInteger.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                if(mPresenter!=null){
                    mPresenter.deliverResult(integer);
                }
            }
        });
    }


}
