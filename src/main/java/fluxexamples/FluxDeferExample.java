package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;

import java.util.List;


public class FluxDeferExample
{
    public static void main(String[] args)
    {
        var list = List.of("a", "b", "c");

       Flux.defer(() -> Flux.fromIterable(list)).subscribe(Util.subscriber());
    }


}
