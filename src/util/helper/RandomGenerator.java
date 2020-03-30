package util.helper;

import java.util.Random;
import java.util.UUID;

public class RandomGenerator {

    public static int generateId() {
        return Math.abs(UUID.randomUUID().toString().hashCode() % Integer.MAX_VALUE);
    }

    public static int generateRandomInt(int max) {
        Random random = new Random();

        return random.nextInt(max);
    }
}
