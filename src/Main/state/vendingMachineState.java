package Main.state;

public interface vendingMachineState {

    String getState();
    public vendingMachineState next(vendingMachineContext context);
}
