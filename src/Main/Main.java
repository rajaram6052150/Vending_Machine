//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Main;

import Main.state.vendingMachineContext;

public class Main {
    public static void main(String[] args) {

        vendingMachineContext context = new vendingMachineContext();

        for (int i = 0; i < 5; i++) {
            int code = 101 + i;
            for (int j = 0; j < 3; j++) {
                item newItem = new item();
                newItem.setType(itemType.CHIPS);
                newItem.setPrice(10); // optional
                context.addItem(newItem, code);
            }
        }

        context.inv1.showItems();

        context.chooseProduct(102);
        context.chooseProduct(102);
        context.chooseProduct(102);
        context.chooseProduct(102);

        context.inv1.showItems();



    }
}