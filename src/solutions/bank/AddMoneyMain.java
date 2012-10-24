package solutions.bank;

import java.util.Random;

/**
 * Starts several AddMoney transactions.
 */
public class AddMoneyMain {
    /**
     * Generates 2 random int[] and feeds it to a thread that uses the AddMoney
     * runnable.
     */
    public static void main(String[] args) {
        Random rand = new Random();
        rand.setSeed(0);
        for (int j = 0; j < 1000000; j++) {
            final int NUM = 50;
            int expected = 0;
            int[] moneys1 = new int[50];
            int[] moneys2 = new int[50];
            for (int i = 0; i < NUM; i++) {
                moneys1[i] = rand.nextInt(500);
                moneys2[i] = rand.nextInt(500);
                expected += moneys1[i];
                expected += moneys2[i];
            }

            Account account = new Account(0, 0);

            Thread[] threads = new Thread[] {
                new Thread(new AddMoney(account, moneys1), "Thread-1"),
                new Thread(new AddMoney(account, moneys2), "Thread-2"),
            };

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (account.getBalance() != expected) {
                System.out.printf("Balance was %d, supposed to be %d\n",
                        account.getBalance(), expected);
            }
        }
    }
}
