package main;

import dao.AccountDaoImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountDaoImpl dao = new AccountDaoImpl();

        while (true) {
            System.out.println("\n===== ACCOUNT MANAGER =====");
            System.out.println("1. Add new item");
            System.out.println("2. Delete item");
            System.out.println("3. Search by title");
            System.out.println("4. Search by date");
            System.out.println("5. Show all items of a specific day");
            System.out.println("6. Daily summary (income/expense)");
            System.out.println("7. Monthly summary");
            System.out.println("8. Period summary (between two dates)");
            System.out.println("9. Show all items");
            System.out.println("10. Save & Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> dao.insert();
                case 2 -> dao.delete();
                case 3 -> dao.searchByTitle();
                case 4 -> dao.searchByDate();
                case 5 -> dao.showItemsOfDay();
                case 6 -> dao.dailySummary();
                case 7 -> dao.monthlySummary();
                case 8 -> dao.periodSummary();
                case 9 -> dao.all();
                case 10 -> {
                    dao.save();
                    System.out.println("Saved and exiting. Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Wrong choice!");
            }
        }
    }
}