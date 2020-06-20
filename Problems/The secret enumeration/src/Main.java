public class Main {

    public static void main(String[] args) {
        System.out.println(hasSTAR());
    }


/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}
*/


    public static int hasSTAR() {
        int count = 0;

        for (Secret value : Secret.values()) {
            if (value.name().startsWith("STAR")) {
                count++;
            }
        }
        return count;
    }
}