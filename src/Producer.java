import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<Drink> drinkQueue;
    Buffer buffer;

    public Producer(Buffer buffer, BlockingQueue<Drink> drinkQueue) {
        this.buffer = buffer;
        this.drinkQueue = drinkQueue;
    }

    @Override
    public void run() {
        System.out.println("Producer started");
        produce();
    }

    public synchronized void produce() {
        Random random = new Random();
        while(true){
                for (int i = 0; i < 10; i++) {
                    try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                    int choice = random.nextInt(2);
                    if (choice == 0) {
                        try {
                            buffer.addDrink(new Beer("Duff Beer no " + i));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Duff Beer " + i +" produced");
                    }
                    if (choice == 1) {
                        try {
                            buffer.addDrink(new Soda("Buzz Cola no " + i));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Buzz Cola " + i + " produced");

                    }
                }
            }
        }

}







