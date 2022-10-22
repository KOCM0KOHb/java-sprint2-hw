import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        YearlyReport yearlyReport = new YearlyReport();

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();

        System.out.println("Приветствуем Вас в приложении для учёта бухгалтерии! ");
        System.out.println("Проверьте место расположения и корректность файлов отчета");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.readMonthReport();
            } else if (command == 2) {
                yearlyReport.readReportOfYear();
            } else if (command == 3) {
                ForHelp.orderReport(monthlyReport, yearlyReport);
            } else if (command == 4) {
                monthlyReport.MaxReport();
            } else if (command == 5) {
                yearlyReport.monthReport();
                yearlyReport.toAverYearRep();

            } else if (command == 0) {
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Такой команды нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Сделайте выбор: ");
        System.out.println("1. Считать все месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах.");
        System.out.println("5. Вывести информацию о годовом отчёте.");
        System.out.println("0. Выход.");
    }
}