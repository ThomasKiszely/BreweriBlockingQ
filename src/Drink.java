import java.util.List;

public class Drink {
    List<Drink> drinkList;
    String name;
    public Drink(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Drink> getDrinkList() {
        return drinkList;
    }
    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @Override
    public String toString() {
        return name;
    }
}
