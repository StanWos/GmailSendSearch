package helpers;

import java.util.Random;


public class Helpers {
    public static String getUniqueText(String prefix) {
        return prefix + (new Random()).nextInt();
    }
}
