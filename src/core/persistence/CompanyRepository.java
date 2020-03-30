package core.persistence;

import core.datafixture.CompanyFactory;
import util.fixtures.RandomFixtures;
import core.domain.Company;

import java.util.ArrayList;

public class CompanyRepository {
    public ArrayList<Company> findAll() {
        //TODO: replace with real db conn

        RandomFixtures<Company> fixtures = new RandomFixtures<>();

        return fixtures.generateTwelve(new CompanyFactory());
    }
}
