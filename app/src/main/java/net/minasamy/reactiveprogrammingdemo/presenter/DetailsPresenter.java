package net.minasamy.reactiveprogrammingdemo.presenter;

import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.model.ObservableFactory;
import net.minasamy.reactiveprogrammingdemo.view.DetailsView;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class DetailsPresenter {
    private WeakReference<DetailsView> mView;
    private Observable<Integer> mObserver;

    public DetailsPresenter(DetailsView view, DemoItem.DemoItemType demoItemType) {
        this.mView = new WeakReference<DetailsView>(view);
        this.mObserver = ObservableFactory.createObservable(demoItemType);

    }

    public void startDemo() {
        mObserver.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                if(mView.get()!=null){
                    mView.get().onDataLoadingCompleted();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                if (mView.get() != null) {
                    mView.get().onReceiveResult(integer);
                }
            }
        });
    }


}
