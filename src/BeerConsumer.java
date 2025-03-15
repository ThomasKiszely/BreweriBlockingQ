import java.util.List;

public class BeerConsumer implements Runnable {

  List<Beer> beerList;
  public BeerConsumer(List<Beer> beerList) {
      this.beerList = beerList;
  }
    @Override
    public void run() {
        consumeBeer();
    }
    private void consumeBeer() {
        while(true){
            synchronized (beerList) {
            try{
                beerList.wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            while(beerList.size() > 9) {
                for(int i = 9; i >= 0; i--) {
                    System.out.println("Homer consuming " + beerList.get(i) + " " + i + " at Moe's together with Lenny and Carl");
                    beerList.remove(i);
//                for (Beer beer : beerList) {
//                    System.out.println("Homer consuming " + beer + " at Moe's together with Carl and Lenny");
//                    beerList.remove(beer);
               }
            }
          }
        }
    }
}
