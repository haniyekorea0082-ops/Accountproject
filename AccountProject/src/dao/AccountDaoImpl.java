package dao;

import dto.AccountDto;
import file.FileProc;
import single.Singleton;
import java.util.*;

public class AccountDaoImpl implements AccountDao {
    private Scanner sc = new Scanner(System.in);
    private FileProc fileProc;

    public AccountDaoImpl() {
        fileProc = new FileProc("account");
        load();
    }

    @Override
    public void insert() {
        System.out.print("Title: ");
        String item = sc.nextLine();

        System.out.print("Amount: ");
        int money = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        System.out.print("Is it income? (yes/no): ");
        String income = sc.nextLine();

        System.out.print("Is it expense? (yes/no): ");
        String outcome = sc.nextLine();

        System.out.print("Note: ");
        String note = sc.nextLine();

        AccountDto dto = new AccountDto(item, money, date, income, outcome, note);
        Singleton.getInstance().list.add(dto);
        System.out.println("Added!\n");
    }

    public void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = sc.nextLine();
        boolean found = false;
        for (AccountDto d : Singleton.getInstance().list) {
            if (d.getItem().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) System.out.println("Not found!\n");
    }

    public void searchByDate() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();
        boolean found = false;
        for (AccountDto d : Singleton.getInstance().list) {
            if (d.getDate().equals(date)) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) System.out.println("No items on this date.\n");
    }

    public void showItemsOfDay() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();
        System.out.println("=== Items on " + date + " ");
        for (AccountDto d : Singleton.getInstance().list) {
            if (d.getDate().equals(date)) {
                System.out.println(d);
            }
        }
        System.out.println();
    }

    public void dailySummary() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        int totalIncome = 0;
        int totalExpense = 0;

        for (AccountDto d : Singleton.getInstance().list) {
            if (d.getDate().equals(date)) {
                if (d.getIncome().equalsIgnoreCase("yes")) {
                    totalIncome += d.getMoney();
                }
                if (d.getOutcome().equalsIgnoreCase("yes")) {
                    totalExpense += d.getMoney();
                }
            }
        }

        System.out.println(" Daily Summary - " + date);
        System.out.println("Income: " + totalIncome + " toman");
        System.out.println("Expense: " + totalExpense + " toman");
        System.out.println("Balance: " + (totalIncome - totalExpense) + " toman\n");
    }

    public void monthlySummary() {
        System.out.print("Enter year and month (yyyy-mm): ");
        String month = sc.nextLine(); // like 2025-12

        int totalIncome = 0;
        int totalExpense = 0;

        for (AccountDto d : Singleton.getInstance().list) {
            if (d.getDate().startsWith(month)) {
                if (d.getIncome().equalsIgnoreCase("yes")) totalIncome += d.getMoney();
                if (d.getOutcome().equalsIgnoreCase("yes")) totalExpense += d.getMoney();
            }
        }

        System.out.println(" Monthly Report - " + month);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net: " + (totalIncome - totalExpense) + "\n");
    }

    public void periodSummary() {
        System.out.print("Start date (yyyy-mm-dd): ");
        String start = sc.nextLine();
        System.out.print("End date (yyyy-mm-dd): ");
        String end = sc.nextLine();

        int totalIncome = 0;
        int totalExpense = 0;

        for (AccountDto d : Singleton.getInstance().list) {
            String date = d.getDate();
            if (date.compareTo(start) >= 0 && date.compareTo(end) <= 0) {
                if (d.getIncome().equalsIgnoreCase("yes")) totalIncome += d.getMoney();
                if (d.getOutcome().equalsIgnoreCase("yes")) totalExpense += d.getMoney();
            }
        }

        System.out.println(" Report from " + start + " to " + end);
        System.out.println("Income: " + totalIncome);
        System.out.println("Expense: " + totalExpense);
        System.out.println("Balance: " + (totalIncome - totalExpense) + "\n");
    }

    // بقیه متدها (delete, all, save, load, find) همون قبلی بمونه
    // فقط اینا رو اضافه کردم بالا

    @Override public void delete() { /* همون قبلی */ }
    private AccountDto find(String itemName) { /* همون قبلی */ }
    @Override public void all() { /* همون قبلی */ }
    @Override public void save() { fileProc.fileSave(); }
    @Override public void load() { fileProc.fileLoad(); }
    @Override public void select() { } // قدیمی بود، الان استفاده نمیشه
    @Override public void update() { } // اگه خواستی بعداً اضافه کن
}