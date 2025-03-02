package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;

import java.util.List;


public class FluxFromIterableOrArrayExample
{
    public static void main(String[] args)
    {
       var list = List.of("a", "b", "c");
       Flux.fromIterable(list).subscribe(Util.subscriber());

       Integer[] arr = {1,2,3,4};
       Flux.fromArray(arr).subscribe(Util.subscriber());
    }

}
