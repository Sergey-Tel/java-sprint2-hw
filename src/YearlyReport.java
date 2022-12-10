import java.util.ArrayList;
public class YearlyReport {
    ArrayList<ForYearRecord> YearData; //

    YearlyReport() {
        YearData = new ArrayList<>();
    }

    public void readYearReport() {
        String yearReportRew = Additionals.readFileContents("resources/y.2021.csv");
        if (yearReportRew != null) {
            separateReportYear(yearReportRew);
            System.out.println("Годовой отчет считан");
        }
    }


    private void separateReportYear(String yearlyReportRew) {
        String[] lines = yearlyReportRew.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            ForYearRecord record = new ForYearRecord(Integer.parseInt(lineContents[0]), Integer.parseInt(lineContents[1]), Boolean.parseBoolean(lineContents[2]));
            YearData.add(record);
        }
    }


    Integer toTakeYearMonthExpense(int month) {
        for (ForYearRecord forYearRec : YearData) {
            if ((forYearRec.months == month) && (forYearRec.is_exp)) {
                return forYearRec.amounts;
            }
        }
        return null;
    }


    Integer getIncome(int month) {
        for (ForYearRecord forYearRec : YearData) {
            if ((forYearRec.months == month) && (!forYearRec.is_exp)) {
                return forYearRec.amounts;
            }
        }
        return null;
    }

    public void AverageYear() {
        if (YearData.isEmpty()) {
            System.out.println("Данных нет!");
        } else {
            int averagInc = 0;
            int averageExp = 0;
            for (ForYearRecord reportCompare : YearData) {
                if (!reportCompare.is_exp) {
                    averagInc += reportCompare.amounts / 3;
                } else {
                    averageExp += reportCompare.amounts / 3;
                }
            }
            System.out.println("Средний доход составляет: " + averagInc + "\n" + "Средний расход составляет: " + averageExp);
        }
    }


    public void monthsReport() {
        if (YearData.isEmpty()) {
            System.out.println("Отчетов еще нет!");
        } else {
            int moneyProfit = 0;
            int incrProfit = 0;
            int exprProfit = 0;
            for (ForYearRecord reportCompare : YearData) {
                if (!reportCompare.is_exp) {
                    incrProfit = reportCompare.amounts;
                } else {
                    exprProfit = reportCompare.amounts;
                }
            }
            moneyProfit = incrProfit - exprProfit;
            System.out.println("Доход составил: " + moneyProfit);
        }
    }


    public boolean isNotFull() {
        return  YearData.size() == 0;
    }
}
