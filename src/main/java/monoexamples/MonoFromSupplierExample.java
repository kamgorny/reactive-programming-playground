package monoexamples;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromSupplierExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoFromSupplierExample.class);

    public static void main(String[] args)
    {
        var list = List.of(1, 2, 3);

        //Use if we want to delay compute intensive operations. Using just here would be a waste of CPU.
        Mono.fromSupplier(() -> sum(list)).subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list)
    {
        logger.info("Finding the sum of {}", list);

        return list.stream().mapToInt(a -> a).sum();
    }

}
