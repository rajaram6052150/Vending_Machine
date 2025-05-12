package Main.utilityClasses;
import java.util.ArrayList;
import java.util.List;

public class inventory {

    private List<itemShelf> inventory;

    public inventory(int count) {
        inventory = new ArrayList<itemShelf>(count);
        for (int i = 0; i < count; i++) {
            int code = 101 + i;
            inventory.add(new itemShelf(code));
        }
    }

    public void addItem(item item , int code) {
        for (itemShelf i : inventory) {
            if (i.code == code){
                i.addItem(item);
            }
        }
    }

    public void showItems(){
        for (itemShelf i : inventory) {
            i.showItems();
        }
    }
    public void removeItem(int code) {
        for (itemShelf i : inventory) {
            if (i.code == code){
                i.removeItem();
            }
        }
    }

    public int getPrice(int code) {
        for (itemShelf i : inventory) {
            if (i.code == code){
                return i.getPrice(i);
            }
        }
        return 0;
    }

    public boolean getItem(int code){
        for (itemShelf i : inventory) {
            if (i.code == code && !i.isSoldout){
                return i.removeItem();
            }
        }
        return false;
    }

    public boolean hasItems(){
        int cnt = 0;
        for (itemShelf i : inventory) {
            if (!i.isSoldout){
                cnt++;
            }
        }
        return cnt > 0 ? true : false;
    }

    public boolean isOutOfStock(int code){
        for (itemShelf i : inventory) {
            if (i.code == code && !i.isSoldout) {
                return true;
            }
        }
        return false;
    }


}
