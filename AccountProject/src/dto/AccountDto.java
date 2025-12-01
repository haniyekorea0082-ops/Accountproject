package dto;

public class AccountDto {
    private String item;
    private int money;
    private String date;
    private String income;
    private String outcome;
    private String note;

    public AccountDto() {}

    public AccountDto(String item, int money, String date, String income, String outcome, String note) {
        this.item = item;
        this.money = money;
        this.date = date;
        this.income = income;
        this.outcome = outcome;
        this.note = note;
    }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getIncome() { return income; }
    public void setIncome(String income) { this.income = income; }
    public String getOutcome() { return outcome; }
    public void setOutcome(String outcome) { this.outcome = outcome; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "Item: " + item + " | Money: " + money + " | Date: " + date +
               " | Income: " + income + " | Outcome: " + outcome + " | Note: " + note;
    }

    public String getDataLine() {
        return item + "-" + money + "-" + date + "-" + income + "-" + outcome + "-" + note;
    }
}