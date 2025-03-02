package fluxexamples.fluxcreate.generator;

import common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

/*
 * Not robust solution - just for demonstration purposes.
 */
public class FluxCreateNameGenerator implements Consumer<FluxSink<String>> {

    private FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.sink = stringFluxSink;
    }

    public void generate()
    {
        if(this.sink != null)
        {
            this.sink.next(Util.faker().country().name());
        }
    }

}
