package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;


public class FluxIntervalExample
{
    public static void main(String[] args)
    {
        Flux.interval(Duration.ofMillis(500))
                .map(i -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());

        //Sleep is necessary to actually see the data.
        // Flux uses different thread, so if we want to see anything, we have to keep main thread busy.
        Util.sleepSeconds(5);
    }


}
