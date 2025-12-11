class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    public void printDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Withdrawal denied! Insufficient balance.");
        } else {
            super.withdraw(amount);
        }
    }
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest);
    }
}
public class Bankingsystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("AC001", "John Doe", 5000);
        acc1.deposit(1000);
        acc1.withdraw(3000);
        acc1.printDetails();
        SavingsAccount savAcc = new SavingsAccount("SA001", "Alice", 8000, 5.0);
        savAcc.deposit(2000);
        savAcc.withdraw(12000);
        savAcc.withdraw(3000);
        savAcc.applyInterest();
        savAcc.printDetails();
    }
}
