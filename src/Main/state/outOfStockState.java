package Main.state;

public class outOfStockState implements vendingMachineState{
    public outOfStockState(){
        System.out.println("outOfStockState");
    }
    public String getState(){
        return "outOfStock";
    }
    public vendingMachineState next(vendingMachineContext context){
        System.out.println("Out of stock");
        return new idleState();
    }
}
