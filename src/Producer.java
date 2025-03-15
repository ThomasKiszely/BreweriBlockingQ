import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    List<Drink> drinkList;

    public Producer(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @Override
    public void run() {
        produce();
    }

    public synchronized void produce() {
        Random random = new Random();
        while(true){
            synchronized (drinkList) {
                for (int i = 0; i < 10; i++) {
                    int choice = random.nextInt(2);
                    if (drinkList.size() == 10) {
                        System.out.println("Drink queue is full - notifying");
                        drinkList.notify();
                        try {
                            drinkList.wait();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (choice == 0) {
                        drinkList.add(new Beer("Duff Beer no " + i));
                        System.out.println("Duff Beer produced");
                    }
                    if (choice == 1) {
                        drinkList.add(new Soda("Buzz Cola no " + i));
                        System.out.println("Buzz Cola produced");
                    }
                }
            }
        }
    }
}







