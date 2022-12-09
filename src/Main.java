import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        YearlyReport yearlyReport = new YearlyReport();

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();

        System.out.println("Доброго времени суток в мою программу)");
        System.out.println("Перед началом работы сверьте правильность всех файлов)");

        while (true) {

            printMenu();

            int command = scanner.nextInt();

            if (command == 1) {
                monthlyReport.readMonthsReport();
            } else if (command == 2) {
                yearlyReport.readYearReport();
            } else if (command == 3) {
                Additionals.ReportDif(monthlyReport, yearlyReport);
            } else if (command == 4) {
                monthlyReport.ForFindingExOrLowStaff();
            } else if (command == 5) {
                yearlyReport.monthsReport();
                yearlyReport.AverageYear();

            } else if (command == 0) {
                System.out.println("Программа прекращает работу");
                break;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите задачу из приведенного меню: ");
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход из программы");
    }
}