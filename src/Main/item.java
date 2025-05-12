package Main;

public class item {

    private itemType type;
    private int price;

    public itemType getType(){
        return type;
    }

    public void setType(itemType type){
        this.type = type;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}
