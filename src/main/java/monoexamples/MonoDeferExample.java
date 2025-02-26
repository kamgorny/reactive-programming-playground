package monoexamples;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoDeferExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoDeferExample.class);

    public static void main(String[] args)
    {
       Mono.defer(MonoDeferExample::createPublisher);
    }

    private static Mono<Integer> createPublisher()
    {
        logger.info("Creating publisher");
        var list = List.of(1, 2, 3);
        Util.sleepSeconds(1);
        return Mono.fromSupplier(() -> sum(list));
    }

    //Let's say it's some time-consuming business logic
    private static int sum(List<Integer> list)
    {
        logger.info("Finding the sum of {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a -> a).sum();
    }


}
