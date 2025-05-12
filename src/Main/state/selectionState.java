package Main.state;
import Main.state.outOfStockState;
import Main.state.dispenseState;

public class selectionState implements vendingMachineState {
    public selectionState() {
        System.out.println("Product Selection State");
    }
    public String getState(){
        return "Product selection";
    }
    public vendingMachineState next(vendingMachineContext context){

        if (!context.inv1.hasItems()){
            return new outOfStockState();
        }

        return new dispenseState();
    }
}
