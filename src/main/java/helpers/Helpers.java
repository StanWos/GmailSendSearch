package helpers;

import java.util.Random;


public class Helpers {
    public static String getUniqueText() {
        return "test message" + (new Random()).nextInt();
    }
}
