package fluxexamples;

import demobasicimpl.subscriber.DemoSubscriber;
import fluxexamples.generators.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluxVsListExample
{
    public static final Logger logger = LoggerFactory.getLogger(FluxVsListExample.class);
    public static void main(String[] args)
    {
//        var list = NameGenerator.getNamesList(10);
//        logger.info(String.valueOf(list));

        var subscriber = new DemoSubscriber();
        NameGenerator.getNamesFlux(10).subscribe(subscriber);

        subscriber.getSubscription().request(3);
//        subscriber.getSubscription().cancel();
    }

}
