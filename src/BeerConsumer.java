import java.util.List;
import java.util.concurrent.BlockingQueue;

public class BeerConsumer implements Runnable {
    BlockingQueue<Beer> beerQueue;
    Buffer buffer;
    Beer beer;

  public BeerConsumer(Buffer buffer, BlockingQueue<Beer> beerQueue) {
      this.buffer = buffer;
      this.beerQueue = beerQueue;
  }
    @Override
    public void run() {
      System.out.println("Homer started drinking");
      consumeBeer();
    }
    private void consumeBeer() {
        while(true){
            try {
                beer = buffer.getBeer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Homer consuming " + beer +  " " + " at Moe's together with Lenny and Carl");
        }
  }
}

