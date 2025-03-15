import java.util.List;

public class Splitter implements Runnable{
    List<Beer> beerList;
    List<Soda> sodaList;
    List<Drink> drinkList;

    public Splitter(List<Beer> beerList, List<Soda> sodaList, List<Drink> drinkList) {
        this.beerList = beerList;
        this.sodaList = sodaList;
        this.drinkList = drinkList;
    }

    @Override
    public void run() {
        System.out.println("Splitter started");
        splitBeerAndSoda();
    }
    private synchronized void splitBeerAndSoda() {
        while(true){
            synchronized (drinkList){
                for (int i = 9; i >= 0; i--) {
                    if (drinkList.isEmpty()){
                        System.out.println("No more drinks found");
                        try {
                            drinkList.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (drinkList.get(i) instanceof Soda) {
                        sodaList.add((Soda) drinkList.get(i));
                        System.out.println("Soda added");
                        System.out.println(drinkList.size());
                        drinkList.remove(drinkList.get(i));
                        if (sodaList.size() == 10){
                            synchronized (sodaList){
                                sodaList.notify();
                            }
                        }
                    }
                    else if (drinkList.get(i) instanceof Beer) {
                        beerList.add((Beer)(drinkList.get(i)));
                        System.out.println("Beer added");
                        System.out.println(drinkList.size());
                        drinkList.remove(drinkList.get(i));
                        if (beerList.size()==10){
                            synchronized (beerList){
                                beerList.notify();
                            }
                        }
                    }
                }
                drinkList.notify();
            }
        }
    }
}




