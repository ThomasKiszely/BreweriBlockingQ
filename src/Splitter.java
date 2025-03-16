import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Splitter implements Runnable{
    BlockingQueue<Drink> drinkQueue;
    BlockingQueue<Soda> sodaQueue;
    BlockingQueue<Beer> beerQueue;
    Buffer buffer;
    Drink drink;

    public Splitter(Buffer buffer, BlockingQueue<Beer> beerQueue, BlockingQueue<Soda> sodaQueue, BlockingQueue<Drink> drinkQueue) {
        this.buffer = buffer;
        this.beerQueue = beerQueue;
        this.sodaQueue = sodaQueue;
        this.drinkQueue = drinkQueue;
    }

    @Override
    public void run() {
        System.out.println("Splitter started");
        splitBeerAndSoda();
    }
    private void splitBeerAndSoda() {
        while(true){
            try {
                drink = buffer.getDrink();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (drink instanceof Soda) {
                try {
                    buffer.addSoda((Soda) drink);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Soda added " + drink);
            }
            else if (drink instanceof Beer) {
                try {
                    buffer.addBeer((Beer) drink);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Beer added " + drink);
            }
        }
    }
}




