package fluxexamples.fluxcreate;

import common.Util;
import fluxexamples.fluxcreate.generator.FluxCreateNameGenerator;
import reactor.core.publisher.Flux;

public class FluxCreateExample
{
    public static void main(String[] args)
    {
        var generator = new FluxCreateNameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber());

        for (int i = 0; i < 10; i++)
        {
         generator.generate();
        }
    }
}
