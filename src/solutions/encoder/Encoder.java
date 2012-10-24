package solutions.encoder;

/** Encoders are completely useless classes that serve only to make a point. */
public class Encoder {
    /** Codes to add. */
    static final String[] codes = {
        "a b c d e f",
        "g h i j k l",
        "m n o p q r",
        "s t u v w x"
    };

    /** String builder to add codes to. */
    private final StringBuilder sb = new StringBuilder();

    /**
     * Adds a code to the string builder.
     * @param i Index of the code to add.
     */
    private void addCode(int i) {
        String[] elems = codes[i].split(" ");
        for (String elem : elems) {
            sb.append(elem);
        }
    }

    /**
     * Creates 4 threads, gets one of the codes, splits the code on spaces, and
     * adds each word in its code to the string builder.
     * @return A string composed by interleaving codes.
     */
    public String interleave() {
        final int NUM_THREADS = 4;
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadNum = i;
            threads[i] = new Thread(String.format("Code-%d", threadNum)) {
                @Override
                public void run() {
                    addCode(threadNum);
                }
            };
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /** Runs 5,000 threads to generate several code strings. */
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            Encoder foo = new Encoder();
            String str = foo.interleave();
            if (str.length() != 24) {
                System.out.println(str);
            }
        }
    }
}
