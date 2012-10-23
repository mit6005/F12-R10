package encoder;

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
        // TODO Split the code on spaces and add it to the string builder.
    }

    /**
     * Creates 4 threads, gets one of the codes, splits the code on spaces, and
     * adds each word in its code to the string builder.
     * @return A string composed by interleaving codes.
     */
    public String interleave() {
        // TODO Interleave the codes into one large string.
        // Spawn 4 threads to interleave the codes

        return sb.toString();
    }

    /** Runs 5,000 threads to generate several code strings. */
    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            Encoder foo = new Encoder();
            System.out.println(foo.interleave());
        }
    }
}
