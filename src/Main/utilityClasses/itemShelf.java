package Main.utilityClasses;
import java.util.*;

public class itemShelf {

    private List<item> shelf;
    public int code;
    boolean isSoldout = false;

    public itemShelf(int code){
        this.code = code;
        this.shelf = new ArrayList<>();
    }

    public int getPrice(itemShelf i){
        for (item it : shelf){
            return it.getPrice();
        }
        return 0;
    }

    public void addItem(item i){
        isSoldout = false;
        shelf.add(i);
    }

    public void showItems() {
        System.out.println("Shelf Code: " + code);
        for (item i : shelf) {
            System.out.println("  Type: " + i.getType() + ", Price: ₹" + i.getPrice());
        }
    }
    public boolean removeItem(){

        if (shelf.size() > 0){
            shelf.removeLast();
            if (shelf.size() == 0){isSoldout = true;}
            return true;
        }
        return false;
    }

}
