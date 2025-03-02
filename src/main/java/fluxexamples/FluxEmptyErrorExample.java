package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;


public class FluxEmptyErrorExample
{
    public static void main(String[] args)
    {
       Flux.empty()
               .subscribe(Util.subscriber());

       Flux.error(new RuntimeException("Error"))
               .subscribe(Util.subscriber());
    }


}
