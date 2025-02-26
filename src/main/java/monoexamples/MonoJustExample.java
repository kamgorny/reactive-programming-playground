package monoexamples;

import reactor.core.publisher.Mono;
import demobasicimpl.subscriber.DemoSubscriber;

public class MonoJustExample
{
    public static void main(String[] args)
    {
        Mono<String> mono = Mono.just("foo");
        var subscriber = new DemoSubscriber();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
    }
}
