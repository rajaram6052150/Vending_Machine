package Main.state;
import Main.utilityClasses.inventory;
import Main.utilityClasses.item;
import Main.Enums.coins;
import java.util.List;
import java.util.ArrayList;

public class vendingMachineContext {
    vendingMachineState currentState;
    int selectedCode ;
    public inventory inv1 ;
    public List<coins> coinsList;

    public vendingMachineContext(){
        inv1 = new inventory(5);
        currentState = new idleState();
        coinsList = new ArrayList<>();
    }

    public int balance(){
        int tot = 0;
        for (coins i : coinsList) {
            tot += i.value;
        }
        return tot;
    }

    public void insertCoin(coins coin){
        if (currentState instanceof idleState || currentState instanceof hasMoneyState){
            if (currentState instanceof idleState){
                advanceState();
            }
            coinsList.add(coin);
        }
    }

    public void setCurrentState(vendingMachineState currentState){

        this.currentState = currentState;
    }
    public String getCurrentState(){

        return currentState.getState();
    }

    public void addItem(item item , int code){
        inv1.addItem(item , code);
    }

    public void advanceState(){
        vendingMachineState next = currentState.next(this);
        currentState = next;
        //System.out.println(currentState.getState());
    }

    public void chooseProduct(int code){
        if (currentState instanceof hasMoneyState){
            int pro_price = inv1.getPrice(code);
            if (balance() >= pro_price){
                advanceState();
                selectProduct(code);
            }
            else{
                System.out.println("Insufficient funds");
            }
        }
        else{
            System.out.println("Insufficient funds");
        }
    }

    public void selectProduct(int code){
        if (currentState instanceof selectionState && inv1.getItem(code)){
            advanceState();
            dispense();
        }
        else {
            System.out.println("No items in inventory");
        }
    }

    public void dispense(){
        advanceState();
    }


}
