package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;

import static common.Util.faker;


public class FluxRange
{
    public static void main(String[] args)
    {
        Flux.range(1,10)
                .map(i -> faker().name().firstName())
                .subscribe(Util.subscriber());
    }


}
