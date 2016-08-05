package net.minasamy.reactiveprogrammingdemo.model;

/**
 * Created by Mina Samy on 8/5/2016.
 */
public class DemoCommandFactory {

    static public BasicObservableCommand createDemoItem(DemoItem.DemoItemType itemType) {
        switch (itemType) {
            case BASIC_OBSERVABLE:
            default: {
                return new BasicObservableCommand();
            }
        }
    }
}
