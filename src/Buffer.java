import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {
    private final BlockingQueue<Beer> beerQueue = new LinkedBlockingQueue<>(10);
    private final BlockingQueue<Soda> sodaQueue = new LinkedBlockingQueue<>(10);
    private final BlockingQueue<Drink> drinkQueue = new LinkedBlockingQueue<>(10);

    public void addDrink(Drink drink) throws InterruptedException {
        drinkQueue.put(drink); // Trådsikkert
    }

    public Drink getDrink() throws InterruptedException {
        return drinkQueue.take(); // Trådsikkert
    }
    public void addBeer(Beer beer) throws InterruptedException {
        beerQueue.put(beer);
    }
    public Beer getBeer() throws InterruptedException {
        return beerQueue.take();
    }
    public void addSoda(Soda soda) throws InterruptedException {
        sodaQueue.put(soda);
    }
    public Soda getSoda() throws InterruptedException {
        return sodaQueue.take();
    }
}

