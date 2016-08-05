package net.minasamy.reactiveprogrammingdemo.presenter;

import net.minasamy.reactiveprogrammingdemo.model.DemoCommandFactory;
import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.model.ReactiveDemoCommand;
import net.minasamy.reactiveprogrammingdemo.view.DetailsView;

import java.lang.ref.WeakReference;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class DetailsPresenter implements Presenter<Integer> {
    private WeakReference<DetailsView> mView;
    private ReactiveDemoCommand mDemoCommand;

    public DetailsPresenter(DetailsView view, DemoItem.DemoItemType demoItemType){
        this.mView=new WeakReference<DetailsView>(view);
        this.mDemoCommand= DemoCommandFactory.createDemoItem(demoItemType);
        this.mDemoCommand.setReceiverPresenter(this);
    }

    public void startDemo(){
        mDemoCommand.execute();
    }

    @Override
    public void deliverResult(Integer result) {
        if(mView.get()!=null){
            mView.get().onReceiveResult(result);
        }
    }
}
