package util.fixtures;

/**
 * Factory for fixtures schema
 * @param <T> Domain model factory
 */
public interface Factory<T> {
    T createRandom();
}
