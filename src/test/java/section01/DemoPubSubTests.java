package section01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import section01.publisher.DemoPublisher;
import section01.subscriber.DemoSubscriber;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;


public class DemoPubSubTests
{
    private DemoPublisher publisher;
    private DemoSubscriber subscriber;

    @BeforeEach
    void setUp()
    {
        publisher = new DemoPublisher();
        subscriber = new DemoSubscriber();
    }

    @Test
    void subscribe_shouldGetSubscription()
    {
        publisher.subscribe(subscriber);
        Subscription subscription = subscriber.getSubscription();

        assertInstanceOf(Subscription.class, subscription);

    }


}
