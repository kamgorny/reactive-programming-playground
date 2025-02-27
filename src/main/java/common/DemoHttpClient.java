package common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public abstract class DemoHttpClient
{
    public static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;


    public DemoHttpClient()
    {
        var loopResources = LoopResources.create("test", 1, true);
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL);
    }
}
