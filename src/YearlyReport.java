import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearRecord> YearRecs;

    YearlyReport() {
        YearRecs = new ArrayList<>();
    }

    public void readReportOfYear() {
        String yearReportRew = ForHelp.readFileContentsOrNull("resources/y.2021.csv");
        if (yearReportRew != null) {
            separateReportYear(yearReportRew);
            System.out.println("Годовой отчет считан.");
        }
    }

    private void separateReportYear(String yearlyReportRew) {
        String[] lines = yearlyReportRew.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            YearRecord record = new YearRecord(Integer.parseInt(lineContents[0]), Integer.parseInt(lineContents[1]), Boolean.parseBoolean(lineContents[2]));
            YearRecs.add(record);
        }
    }

    Integer getExpense(int month) {
        for (YearRecord yearRecord : YearRecs) {
            if ((yearRecord.months == month) && (yearRecord.isExp)) {
                return yearRecord.amounts;
            }
        }
        return null;
    }

    Integer getIncome(int month) {
        for (YearRecord forYearRec : YearRecs) {
            if ((forYearRec.months == month) && (!forYearRec.isExp)) {
                return forYearRec.amounts;
            }
        }
        return null;
    }

    public void toAverYearRep() {
        if (YearRecs.isEmpty()) {
            System.out.println("Считайте данные из отчётов!");
        } else {
            int averageInc = 0;
            int averageExp = 0;
            for (YearRecord reportCompare : YearRecs) {
                if (!reportCompare.isExp) {
                    averageInc += reportCompare.amounts / 3;
                } else {
                    averageExp += reportCompare.amounts / 3;
                }
            }
            System.out.println("Средний расход составляет: " + averageExp + "\n" + "Средний доход составляет: " + averageInc);
        }
    }

    public void monthReport() {
        int moneyProfit;
        for (int i = 1; i < 4; i++) {
            moneyProfit = getIncome(i) - getExpense(i);
            System.out.println("Прибыль за " + MonthsName.toGetNameOfMonth(i) + " месяц составила: " + moneyProfit);
        }
    }

    public boolean isNotFull() {
        if (YearRecs.size() != 0) {
            return false;
        } else {
            return true;
        }
    }
}