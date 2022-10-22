import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ForHelp {

    static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом по адресу " + path + ". Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static void orderReport(MonthlyReport MonthReport, YearlyReport YearReport) {
        boolean check = true;
        if (!MonthReport.isNotFull() && !YearReport.isNotFull()) {
            for (int i = 1; i < 4; i++) {
                if ((MonthReport.getIncome(i) != YearReport.getIncome(i)) ||
                        (MonthReport.getExpense(i) != (YearReport.getExpense(i)))) {
                    System.out.println(MonthsName.toGetNameOfMonth(i) + " не совпадают.");
                    check = false;
                }
            }
            if (check) {
                System.out.println("Значения в отчетах совпадают.");
            }
        } else {
            System.out.println("Отчёты не загружены.");
        }
    }
}