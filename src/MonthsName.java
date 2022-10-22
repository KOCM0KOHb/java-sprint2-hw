public class MonthsName {

    static String[] months = new String[]{
            "Январь", "Февраль", "Март"
    };

    public static String toGetNameOfMonth(int number) {

        return months[number - 1];
    }
}