import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SodaConsumer implements Runnable{
    BlockingQueue<Soda> sodaQueue;
    Buffer buffer;
    Soda soda;
    public SodaConsumer(Buffer buffer, BlockingQueue<Soda> sodaQueue) {
        this.buffer = buffer;
        this.sodaQueue = sodaQueue;
    }
    @Override
    public void run() {
        System.out.println("Bart started to pull Lisa's hair");
        consumeSoda();
    }
    private void consumeSoda() {
            while(true){

                try {
                    soda = buffer.getSoda();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bart & Lisa consuming " + soda);
            }
    }
}

