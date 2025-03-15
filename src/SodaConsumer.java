import java.util.List;

public class SodaConsumer implements Runnable{
    List<Soda> sodaList;
    public SodaConsumer(List<Soda> sodaList) {
        this.sodaList = sodaList;
    }
    @Override
    public void run() {
        consumeSoda();
    }
    private void consumeSoda() {
            while(true){
                synchronized (sodaList) {
                try{
                    sodaList.wait();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                while (sodaList.size() > 9) {
                    for(int i = 9; i >= 0; i--) {
                        System.out.println("Bart & Lisa consuming " + sodaList.get(i) + " " + i);
                        sodaList.remove(i);
                    }
                }
            }
        }
    }
}

