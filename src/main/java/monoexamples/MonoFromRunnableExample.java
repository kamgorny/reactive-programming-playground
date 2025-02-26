package monoexamples;

import common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoFromRunnableExample
{
    public static final Logger logger = LoggerFactory.getLogger(MonoFromRunnableExample.class);

    public static void main(String[] args)
    {
        /*For example: We want to get a product that is unavailable and we want to notify
        business instead of just returning Mono.empty().
        * */
        getProductName(1).subscribe(Util.subscriber());
    }

    private static Mono<String> getProductName(int productId)
    {
        if(productId == 1)
        {
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }

    public static void notifyBusiness(int productId)
    {
        logger.info("Notifying business on unavailable product: {}", productId);
    }

}
