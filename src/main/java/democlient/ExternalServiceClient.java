package democlient;

import common.DemoHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends DemoHttpClient
{

    public Mono<String> getProductName(int productId)
    {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                .responseContent()
                .asString()
                .next();
    }
}
