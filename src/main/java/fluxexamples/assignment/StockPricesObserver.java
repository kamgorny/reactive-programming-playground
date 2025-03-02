package fluxexamples.assignment;

import common.DefaultSubscriber;
import lombok.Getter;
import lombok.Setter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class StockPricesObserver implements Subscriber<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultSubscriber.class);
    private Subscription subscription;
    private Integer stockCount;
    private Integer balance;

    public StockPricesObserver()
    {
        this.balance = 1000;
        this.stockCount = 0;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        if(price < 90)
        {
            this.balance = (balance - price);
            this.stockCount += 1;
            logger.info("Bought stock at price: {}. Total balance: {}. Stock quantity: {}", price, this.balance, this.stockCount);
        }
        if(price >= 110)
        {
            logger.info("Selling stock at price: {}. Stock quantity: {}", price, this.stockCount);
            this.balance += (price * this.stockCount);
            this.stockCount = 0;
            this.subscription.cancel();
            logger.info("Profit: {}", (this.balance - 1000));
        }
    }

    @Override
    public void onError(Throwable throwable)
    {
        logger.error("Something went wrong!", throwable);
    }

    @Override
    public void onComplete()
    {
        logger.info("Done.");
    }

}
