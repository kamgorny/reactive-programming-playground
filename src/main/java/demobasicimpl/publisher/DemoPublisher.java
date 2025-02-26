package demobasicimpl.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class DemoPublisher implements Publisher<String>
{
    @Override
    public void subscribe(Subscriber<? super String> subscriber)
    {
        var subscription = new DemoSubscription(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
