package monoexamples;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoEmptyErrorExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoEmptyErrorExample.class);

    public static void main(String[] args)
    {
      getUsername(1).subscribe(Util.subscriber());
    }

    private static Mono<String> getUsername(int userId)
    {
        return switch(userId)
        {
            case 1 -> Mono.just("Sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid input!"));
        };
    }
}
