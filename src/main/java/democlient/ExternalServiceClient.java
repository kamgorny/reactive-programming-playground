package democlient;

import common.DemoHttpClient;
import reactor.core.publisher.Flux;
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

    public Flux<String> getProductNamesStream()
    {
        return this.httpClient.get()
                .uri("/demo02/name/stream")
                .responseContent()
                .asString();
    }

    public Flux<Integer> getStockPrice()
    {
        return this.httpClient.get()
                .uri("/demo02/stock/stream")
                .responseContent()
                .asString().map(Integer::parseInt);
    }
}
