import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Additionals {

    static String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("По указанному пути <<" + path + ">> файл не обнаружен. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }


    public static void ReportDif(MonthlyReport forMonthReport, YearlyReport forYearReport) {
        boolean checking = true;
        if (!forMonthReport.isNotFull() && !forYearReport.isNotFull()) {
            for (int i = 1; i < 4; i++) {
                if ((forMonthReport.toGetMonthIncome(i) != forYearReport.getIncome(i)) ||
                        (forMonthReport.toGetOfMonthExpense(i) != (forYearReport.toTakeYearMonthExpense(i)))) {
                    System.out.println(MonthsName.toGetNameOfMonth(i) + " не совпадают");
                    checking = false;
                }
            }
            if (checking) {
                System.out.println("Значения в отчетах совпадают.");
            }
        } else {
            System.out.println("Не загружены отчеты");
        }
    }
}
