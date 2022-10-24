public class MonthRecord {
    String itemNames = " ";
    boolean isExpenses;
    int quantity = 0;
    int sumOfOne = 0;

    public MonthRecord(String itemNames, boolean isExpenses, int quantity, int sumOfOne) {
        this.itemNames = itemNames;
        this.isExpenses = isExpenses;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}