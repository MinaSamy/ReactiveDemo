package net.minasamy.reactiveprogrammingdemo.model;

import net.minasamy.reactiveprogrammingdemo.presenter.Presenter;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public interface ReactiveDemoCommand {
    void execute();
    void setReceiverPresenter(Presenter presenter);
}
