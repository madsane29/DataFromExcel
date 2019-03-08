
import java.util.Date;

public class Transaction {
    
    
    private String type;
    private Date date;
    private int amount;
    private int balance;
    private String where;

    public Transaction(String type, Date date, int amount, int balance, String where) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.where = where;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Type = " + type + "\t\t -> Date = " + date + "\t\t -> Amount = " + amount + "\t\t -> Balance = " + balance + "\t\t -> Where = " + where;
    }
    
    
    
    
    
}
