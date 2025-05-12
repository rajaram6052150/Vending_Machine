package Main.Enums;

public enum coins {
    ONE_RUPEE(1),
    TWO_RUPEES(2),
    FIVE_RUPEES(5),
    TEN_RUPEES(10);

    public int value;

    coins(int value) {
        this.value = value;
    }
}
