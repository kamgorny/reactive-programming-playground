package fluxexamples;

import common.Util;
import democlient.ExternalServiceClient;

public class FluxNonBlockingIOExample
{
    public static void main(String[] args)
    {
        var client = new ExternalServiceClient();
        client.getProductNamesStream().subscribe(Util.subscriber());

        Util.sleepSeconds(6);
    }
}
