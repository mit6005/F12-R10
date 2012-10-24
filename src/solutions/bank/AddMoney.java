package solutions.bank;

/**
 * A transaction that adds money to an account.
 */
public class AddMoney implements Runnable {
    /** The account to add money to. */
    final Account account;

    /** The amounts to add. */
    final int[] moneys;

    /**
     * Create a new add money transaction for the given account and amounts of
     * money.
     * @param account The account to add money to.
     * @param moneys The amounts to add.
     */
    public AddMoney(Account account, int[] moneys) {
        this.account = account;
        this.moneys = moneys;
    }

    /**
     * Adds each int in moneys to the account instance.
     */
    @Override
    public void run() {
        for (int i = 0; i < moneys.length; i++) {
            account.addMoney(moneys[i]);
        }
    }
}
