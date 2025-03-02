package fluxexamples.fluxcreate;

import common.Util;
import reactor.core.publisher.Flux;

public class FluxCreateExample
{
    public static void main(String[] args) {
        Flux.create(fluxSink ->
        {
           String country;
           do {
               country = Util.faker().country().name();
               fluxSink.next(country);
           } while (!country.equalsIgnoreCase("canada"));
           fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
