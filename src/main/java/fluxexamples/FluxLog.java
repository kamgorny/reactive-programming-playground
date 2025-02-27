package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;


public class FluxLog
{
    public static void main(String[] args)
    {
        Flux.range(1,5)
                .log()
                .subscribe(Util.subscriber());
    }


}
