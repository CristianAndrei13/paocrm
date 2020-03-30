package user.services;

import user.domain.User;
import util.helper.RandomGenerator;

import java.util.Random;

/**
 * User builder pattern for User domain model
 */
public class UserBuilder {

    /**
     * Create a basic user
     */
    public static User createBasicUser(String firstName, String lastName, String email) {
        User user = new User();

        setName(user, firstName, lastName);
        user.setEmail(email);
        user.setId(RandomGenerator.generateId());

        return user;
    }

    /**
     * Create a basic admin-role user
     */
    public static User createBasicAdmin(String firstName, String lastName, String email) {
        User user = createBasicUser(firstName, lastName, email);
        user.addRole(User.ROLE_ADMIN);

        return user;
    }

    /**
     * Set full name of user
     */
    private static void setName(User user, String firstName, String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(generateUsername(firstName, lastName));
    }

    /**
     * Generate unique username
     */
    private static String generateUsername(String firstName, String lastName) {
        Random random = new Random();

        return firstName.replaceAll("\\s+", "").toLowerCase() + "-" +
                lastName.replaceAll("\\s+", "").toLowerCase() +
                (int) Math.floor(Math.random() * 10000);
    }

}
