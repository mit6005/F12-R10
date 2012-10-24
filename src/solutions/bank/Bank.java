package solutions.bank;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A bank holds many accounts.
 */
public class Bank {
    /** Accounts in this bank. */
    private List<Account> accounts;

    /** Accounts that need processing. */
    private final Queue<Account> unprocessedAccounts;

    /** The current year. */
    private int currYear;

    /**
     * Creates a new banks with the given number of empty accounts.
     * @param numAccounts The number of empty accounts.
     */
    public Bank(final int numAccounts) {
        accounts = new LinkedList<Account>();

        Thread[] thread = new Thread[] {
            new Thread("Thread-1") {
                @Override
                public void run() {
                    for (int i = 0; i < numAccounts / 2; i++) {
                        accounts.add(new Account(25 * i, i, i * .05));
                    }
                }
            },
            new Thread("Thread-2") {
                @Override
                public void run() {
                    for (int i = numAccounts / 2; i < numAccounts; i++) {
                        accounts.add(new Account(25 * i, i, i * .05));
                    }
                }
            }
        };

        thread[0].start();
        thread[1].start();

        try {
            thread[0].join();
            thread[1].join(); } catch (InterruptedException e) {
            e.printStackTrace();
        }

        currYear = 0;
        unprocessedAccounts = new LinkedList<Account>();
    }

    /**
     * Adds all the accounts to a queue to be processed.  Calls collect interest
     * on each Account and then increment the current year.
     */
    public void computeAndAddInterst() {
        // TODO Create two threads to process the accounts faster!
        unprocessedAccounts.addAll(accounts);
        while (unprocessedAccounts.peek() != null) {
            Account currAccount = unprocessedAccounts.poll();
            currAccount.collectInterest();
        }
        currYear++;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(10);
        System.out.println("Bank should have 10, has " + bank.accounts.size());

        bank = new Bank(100);
        System.out.println("Bank should have 100, has " + bank.accounts.size());

        bank = new Bank(1000);
        System.out.println("Bank should have 1000, has " + bank.accounts.size());

        bank = new Bank(10000);
        System.out.println("Bank should have 10000, has " + bank.accounts.size());

        bank = new Bank(100000);
        System.out.println("Bank should have 100000, has " + bank.accounts.size());

        bank = new Bank(1000000);
        System.out.println("Bank should have 1000000, has " + bank.accounts.size());
    }
}
