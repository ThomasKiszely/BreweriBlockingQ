import java.util.List;

public class Beer extends Drink{

    List<Beer> beerList;

    public Beer(String name) {
        super(name);
    }
    public List<Beer> getBeerList() {
        return beerList;
    }
    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
