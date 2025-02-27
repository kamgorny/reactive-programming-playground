package monoexamples;

import common.Util;
import democlient.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo of non-blocking IO.
 * Please make sure that external service is up and running (the dockerfile is in resources directory).
 */
public class MonoNonBlockingIOExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoNonBlockingIOExample.class);

    public static void main(String[] args)
    {
        var client = new ExternalServiceClient();

        logger.info("starting");

        for( int i = 1; i <= 100; i++)
        {
            client.getProductName(i).subscribe(Util.subscriber());
        }

        client.getProductName(1).subscribe(Util.subscriber());

        Util.sleepSeconds(2);

    }
}
