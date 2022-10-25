public class MonthRecord {
    String itemNames;
    boolean isExpenses;
    int quantity;
    int sumOfOne;

    public MonthRecord(String itemNames, boolean isExpenses, int quantity, int sumOfOne) {
        this.itemNames = itemNames;
        this.isExpenses = isExpenses;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}