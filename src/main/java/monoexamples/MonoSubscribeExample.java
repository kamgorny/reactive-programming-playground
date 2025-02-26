package monoexamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoSubscribeExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoSubscribeExample.class);

    public static void main(String[] args)
    {
        var mono = Mono.just(1);

        logger.info("Only onNext() consumer:");
        mono.subscribe(i -> logger.info("\treceived: {}\n", i));

        // Let's corrupt emitted value on purpose.
        mono = mono.map(i -> i/0);

        logger.info("Consumer + error consumer + complete consumer:");
        mono.subscribe(i -> logger.info("\treceived: {}", i),
                err -> logger.error("error", err),
                () -> logger.info("Complete!"));
    }
}
