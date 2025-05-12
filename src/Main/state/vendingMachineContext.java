package Main.state;
import Main.inventory;
import Main.item;

public class vendingMachineContext {
    vendingMachineState currentState;
    int selectedCode ;
    public inventory inv1 ;

    public vendingMachineContext(){
        inv1 = new inventory(5);
        currentState = new idleState();
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
        if (currentState instanceof idleState || currentState instanceof selectionState){
            advanceState();
            selectProduct(code);
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
