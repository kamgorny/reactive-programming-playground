package fluxexamples.assignment;

import common.Util;
import democlient.ExternalServiceClient;

public class FluxAssignment
{
    public static void main(String[] args)
    {
        var client = new ExternalServiceClient();
        var subscriber = new StockPricesObserver();
        client.getStockPrice().subscribe(subscriber);

        Util.sleepSeconds(20);
    }
}
