package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;


public class FluxJust
{
    public static void main(String[] args)
    {
        Flux.just(1,2,3, "a", "b", "c").subscribe(Util.subscriber());
    }


}
