import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthRecord>> monthsRec = new HashMap<>();

    public void readMonthReport() {
        for (int i = 1; i < 4; i++) {
            String monthlyReportRew = ForHelp.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            if( monthlyReportRew != null) {
                parseMonthReport(monthlyReportRew, i);
                System.out.println("Файл m.20210" + i + " считан.");
            }
        }
    }

    private void parseMonthReport(String monthlyReportRew, int key) {
        String[] lines = monthlyReportRew.split("\n");
        ArrayList<MonthRecord> MonthRecordArrayList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            if (lineContents.length == 4) {
                MonthRecord record = new MonthRecord(
                        lineContents[0],
                        Boolean.parseBoolean(lineContents[1]),
                        Integer.parseInt(lineContents[2]),
                        Integer.parseInt(lineContents[3])
                );
                MonthRecordArrayList.add(record);
                monthsRec.put(key, MonthRecordArrayList);
            } else {
                System.out.println("Ошибка данных!");
            }
        }
    }

    public void MaxReport(){
        if (monthsRec.isEmpty()) {
            System.out.println("Отчетов нет.");
        } else {
            for (Map.Entry<Integer, ArrayList<MonthRecord>> month : monthsRec.entrySet()) {
                int maxIncome = 0;
                int maxExpense = 0;
                String maxIncomeMonthName = " ";
                String maxExpenseMonthName = " ";
                for (MonthRecord reportCompare : month.getValue()) {
                    if (!reportCompare.isExpenses) {
                        int sum = reportCompare.sumOfOne * reportCompare.quantity;
                        if (sum > maxIncome){
                            maxIncome = sum;
                            maxIncomeMonthName = reportCompare.itemNames;
                        }
                    } else {
                        int exp = reportCompare.sumOfOne * reportCompare.quantity;
                        if (exp > maxExpense){
                            maxExpense = exp;
                            maxExpenseMonthName = reportCompare.itemNames;
                        }
                    }
                }
                System.out.println("Отчет за месяц: " + MonthsName.toGetNameOfMonth(month.getKey()) + "\n" + "Наибольшая статья доходов - '" + maxIncomeMonthName + "'. Выручка составила: " + maxIncome + "\n"
                        + "Наибольшая статья расходов за месяц - '" + maxExpenseMonthName + "'. Расход составил: " + maxExpense);
            }
        }
    }

    public int getExpense(int month) {
        int allExpenses = 0;
        for (MonthRecord report : monthsRec.get(month)) {
            if (report.isExpenses) {
                allExpenses += report.quantity * report.sumOfOne;
            }
        }
        return allExpenses;
    }

    public int getIncome(int month) {
        int allIncomes = 0;
        for (MonthRecord report: monthsRec.get(month)) {
            if (!report.isExpenses) {
                allIncomes += report.quantity * report.sumOfOne;
            }
        }
        return allIncomes;
    }

    public boolean isNotFull() {
        if(monthsRec.size() != 0){
            return false;
        } else {
            return true;
        }
    }
}