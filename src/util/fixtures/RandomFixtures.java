package util.fixtures;

import java.util.ArrayList;

/**
 * Fixtures generator
 * @param <T> Domain model of which will generate fixtures
 */
public class RandomFixtures<T> {

    public ArrayList<T> generate(Factory<T> factory, int totalObjectsNo) {
        ArrayList<T> randoms = new ArrayList<>();

        for (int i = 0; i < totalObjectsNo; i++) {
            randoms.add(factory.createRandom());
        }

        return randoms;
    }

    public ArrayList<T> generateTwelve(Factory<T> factory) {
        return this.generate(factory, 12);
    }

}
