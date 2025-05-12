package Main.state;

public class dispenseState implements vendingMachineState {
    public dispenseState() {
        System.out.println("dispenseState");
    }
    public String getState(){
        return "dispenseState";
    }
    public vendingMachineState next(vendingMachineContext context){

        if (!context.inv1.hasItems()){
            return new outOfStockState();
        }

        return new idleState();
    }
}
