package solutions.bank;

/**
 * An account keeps track of a balance (amount of money in the account), an ID,
 * and an interest rate.
 */
public class Account {
    /** Total number of accounts. */
    private static int count = 0;

    /**
     * Returns total number of accounts created.
     * @return Total number of accounts created.
     */
    public static int totalAccounts() {
        return count;
    }

    /** Balance of this account. */
    private int balance = 0;

    /** ID of this account. */
    private int id;

    /** Interest rate. */
    private double interest;

    /** Current year. */
    private int currYear;

    /**
     * Create a new account with $0 balance.
     * @param id Account ID.
     * @param interestRate Account interest rate.
     */
    public Account(int id, double interestRate) {
        this.id = id;
        int cur = count;
        count = cur + 1;
        this.interest = interestRate;
        this.currYear = 0;
    }

    /**
     * Create a new account.
     * @param balance Starting balance.
     * @param id Account ID.
     * @param interestRate Account interest rate.
     */
    public Account(int balance, int id, double interestRate) {
        this.balance = balance;
        this.id = id;
        int cur = count;
        count = cur + 1;
        this.interest = interestRate;
        this.currYear = 0;
    }

    /**
     * Returns the balance in the account.
     * @return The balance in the account.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Returns the account's ID.
     * @Return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the interest rate.
     * @return The interest rate.
     */
    public double getInterestRate() {
        return interest;
    }

    /**
     * Returns the current year.
     * @return The current year.
     */
    public int getCurrYear() {
        return currYear;
    }

    /**
     * Adds money to balance.
     * @param money Amount to add to balance.
     */
    public void addMoney(int money) {
        int temp = balance;
        balance = temp + money;
    }

    /**
     * Collect the interest accumulated over the year and increment the year.
     */
    public void collectInterest() {
        balance = (int)Math.floor(balance * (1 + interest));
        currYear++;
    }
}
