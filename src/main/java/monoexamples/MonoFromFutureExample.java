package monoexamples;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFutureExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoFromFutureExample.class);

    public static void main(String[] args)
    {
        Mono.fromFuture(getName()).subscribe(Util.subscriber());
        Util.sleepSeconds(2);
    }

    private static CompletableFuture<String> getName()
    {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("generating name");
            return Util.faker().name().firstName();
        });
    }

}
