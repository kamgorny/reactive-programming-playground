package common;

import lombok.Getter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo Subscriber for providing email addresses.
 */
@Getter
public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultSubscriber.class);
    private Subscription subscription;
    private final String name;

    public DefaultSubscriber(String name)
    {
        this.name = name;
    }


    @Override
    public void onSubscribe(Subscription subscription)
    {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(T item)
    {
        logger.info("received: {}", item);
    }

    @Override
    public void onError(Throwable throwable)
    {
        logger.error("Something went wrong!", throwable);
    }

    @Override
    public void onComplete()
    {
        logger.info("My work here is done. {}", this.name);
    }

}
