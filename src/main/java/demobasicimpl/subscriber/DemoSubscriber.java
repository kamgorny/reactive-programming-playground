package demobasicimpl.subscriber;

import lombok.Getter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo Subscriber for providing email addresses.
 */
@Getter
public class DemoSubscriber implements Subscriber<String> {

    private static final Logger logger = LoggerFactory.getLogger(DemoSubscriber.class);
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription)
    {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String s)
    {
        logger.info("received: {}", s);
    }

    @Override
    public void onError(Throwable throwable)
    {
        logger.error("Something went wrong!", throwable);
    }

    @Override
    public void onComplete()
    {
        logger.info("My work here is done.");
    }

}
