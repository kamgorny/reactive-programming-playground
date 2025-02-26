package demobasicimpl.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import demobasicimpl.subscriber.DemoSubscriber;

public class DemoSubscription implements Subscription
{
    private static final Logger logger = LoggerFactory.getLogger(DemoSubscriber.class);
    private static final int MAX_ITEMS = 10;
    private final Faker dataFaker;
    private final Subscriber<? super String> subscriber;
    private boolean cancelled;
    private int dataCount = 0;


    public DemoSubscription(Subscriber<? super String> subscriber)
    {
        this.subscriber = subscriber;
        this.dataFaker = Faker.instance();
    }


    @Override
    public void request(long requested)
    {
        if(requested > MAX_ITEMS)
        {
            this.subscriber.onError(new RuntimeException("Requested more than can be produced."));
            this.cancelled = true;
        }

        if(!cancelled)
        {
            logger.info("The subscriber has requested {} items", requested);
            for( int i = 0; i < requested && dataCount < MAX_ITEMS; i++)
            {
                dataCount++;
                this.subscriber.onNext(dataFaker.internet().emailAddress());
            }

            if(dataCount == MAX_ITEMS)
            {
                logger.info("No more data to produce.");
                this.subscriber.onComplete();
                this.cancelled = true;
            }
        }
    }

    @Override
    public void cancel()
    {
        logger.info("Subscription cancelled!");
        this.cancelled = true;
    }
}
