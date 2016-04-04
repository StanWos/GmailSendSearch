package helpers;

import java.util.Random;


public class Helpers {
    public static String subjectText() {
        final Random random = new Random();
        String subjectText = "test message" + random.nextInt();
        return subjectText;
    }
}
