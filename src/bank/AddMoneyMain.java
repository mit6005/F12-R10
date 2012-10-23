package bank;

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
        for (int j = 0; j < 100; j++) {

            int expected = 0;
            int[] moneys1 = new int[50];
            int[] moneys2 = new int[50];
            for (int i = 0; i < 50; i++) {
                moneys1[i] = rand.nextInt(500);
                moneys2[i] = rand.nextInt(500);
                expected += moneys1[i];
                expected += moneys2[i];
            }

            Account account = new Account(0, 0);

            // TODO Create two new threads to process the two int[]s
            //      Print if it's different than the expected amount.

        }
    }
}
