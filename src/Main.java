import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        BlockingQueue<Drink> drinkQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Beer> beerQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Soda> sodaQueue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(buffer, drinkQueue);
        Splitter splitter = new Splitter(buffer, beerQueue, sodaQueue, drinkQueue);
        BeerConsumer beerConsumer = new BeerConsumer(buffer, beerQueue);
        SodaConsumer sodaConsumer = new SodaConsumer(buffer, sodaQueue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(splitter);
        Thread thread3 = new Thread(beerConsumer);
        Thread thread4 = new Thread(sodaConsumer);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}