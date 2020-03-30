package user.datafixture;

import user.domain.User;
import user.services.UserBuilder;
import util.fixtures.Factory;
import util.helper.RandomGenerator;

import java.util.ArrayList;

public class UserFactory implements Factory<User> {

    private ArrayList<String> names = new ArrayList<>();

    public UserFactory() {
        this.names.add("Cristi");
        this.names.add("Alex");
        this.names.add("Cornel");
        this.names.add("Michael");
        this.names.add("Adrian");
        this.names.add("Paul");
    }

    public User createRandom() {

        int namesSize = this.names.size();

        return UserBuilder.createBasicUser(this.names.get(RandomGenerator.generateRandomInt(namesSize)), this.names.get(RandomGenerator.generateRandomInt(namesSize)), "random@test.com");
    }

}
