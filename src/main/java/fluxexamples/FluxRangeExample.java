package fluxexamples;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;



public class FluxRangeExample
{
    public static void main(String[] args)
    {
        Flux.range(1, 10)
                .subscribe(new Subscriber<>() {

                    @Override
                    public void onSubscribe(Subscription subscription) {
                    }

                    @Override
                    public void onNext(Integer next) {
                        System.out.println(next);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("done");
                    }

                });
    }


}
