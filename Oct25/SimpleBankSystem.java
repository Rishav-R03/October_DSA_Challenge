class Bank {
    private final long[] bank;
    private final int n;

    public Bank(long[] bank) {
        this.bank = bank;
        this.n = bank.length;
    }

    private boolean isValid(int acc) {
        return acc > 0 && acc <= n;
    }

    public boolean transfer(int acc1, int acc2, int money) {
        if (!isValid(acc1) || !isValid(acc2) || bank[acc1 - 1] < money) {
            return false;
        }
        bank[acc1 - 1] -= money;
        bank[acc2 - 1] += money;
        return true;
    }

    public boolean deposit(int acc, long money) {
        if (!isValid(acc))
            return false;
        bank[acc - 1] += money;
        return true;
    }

    public boolean withdraw(int acc, int money) {
        if (!isValid(acc) || bank[acc - 1] < money)
            return false;
        bank[acc - 1] -= money;
        return true;
    }
}

public class SimpleBankSystem {
    public static void main(String[] args) {
        long[] accounts = { 1000, 1200, 3000, 200 };
        Bank bank1 = new Bank(accounts);
        int amt = 400;
        if (bank1.deposit(1, amt)) {
            System.out.println("Deposited " + amt);
        }
        if (bank1.withdraw(4, amt)) {
            System.out.println("Withdraw successfull ");
        } else {
            System.out.println("Insufficient balance or invalid acc id");
        }
    }
}