package fluxexamples;

import common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class FluxMonoConversionExample
{
    public static void main(String[] args)
    {
       monoToFlux();
       fluxToMono();
    }

    private static void fluxToMono()
    {
        var flux = Flux.range(1, 10);
        Mono.from(flux)
                .subscribe(Util.subscriber());
    }

    private static void monoToFlux()
    {
        var mono = getUsername(1);
        save(Flux.from(mono));
    }

    private static Mono<String> getUsername(int userId)
    {
        return switch (userId)
        {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }


    public static void save(Flux<String> flux)
    {
        flux.subscribe(Util.subscriber());
    }
}
