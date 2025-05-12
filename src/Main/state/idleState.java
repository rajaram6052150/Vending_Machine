package Main.state;
import Main.state.selectionState;


public class idleState implements vendingMachineState{

    public idleState(){
        System.out.println("Idle  state");
    }

    @Override
    public String getState(){
        return "idle";
    }

    @Override
    public vendingMachineState next(vendingMachineContext context){

        if (!context.inv1.hasItems()){
            return new outOfStockState();
        }

        return new selectionState();
    }
}
