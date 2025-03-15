import java.util.List;

public class Soda extends Drink{
    List<Soda> sodaList;

    public Soda(String name) {
        super(name);
    }
    public List<Soda> getSodaList() {
        return sodaList;
    }
    public void setSodaList(List<Soda> sodaList) {
        this.sodaList = sodaList;
    }
}
