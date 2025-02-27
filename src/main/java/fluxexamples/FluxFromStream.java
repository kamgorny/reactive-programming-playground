package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;


public class FluxFromStream
{
    public static void main(String[] args)
    {
        var dataStream = Stream.of(1, 2, 3, 4, "a");

        //Use fromStream with Stream only when there is one subsciber.
        var flux = Flux.fromStream(dataStream);
        flux.subscribe(Util.subscriber());

        var dataList = List.of(1,2,3,4, "a");

        //Otherwise the provider must be defined.
        flux = Flux.fromStream(dataList::stream);
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));
    }


}
