import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}


class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            displayOptions();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        if (userAccount.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                        }
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        userAccount.deposit(depositAmount);
                        System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 3:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);

    
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
