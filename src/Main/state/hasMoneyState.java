package Main.state;

public class hasMoneyState implements vendingMachineState{
    hasMoneyState(){
        System.out.println("hasMoneyState");
    }
    public String getState(){
        return "has money";
    }
    public vendingMachineState next(vendingMachineContext context){

        if (!context.inv1.hasItems()){
            return new outOfStockState();
        }

        if (context.coinsList.isEmpty()){
            return new idleState();
        }
        return new selectionState();
    }
}
