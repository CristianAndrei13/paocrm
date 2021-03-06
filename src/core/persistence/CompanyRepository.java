package core.persistence;

import core.datafixture.CompanyFactory;
import core.domain.Employee;
import util.fixtures.RandomFixtures;
import core.domain.Company;

import java.util.ArrayList;

public class CompanyRepository {

    private ArrayList<Company> companies = new ArrayList<>();

    public CompanyRepository() {
        RandomFixtures<Company> fixtures = new RandomFixtures<>();
        companies = fixtures.generateTwelve(new CompanyFactory());
    }

    public ArrayList<Company> findAll() {
        //TODO: replace with real db conn

        return companies;
    }

    public Company findById(int id) {
        for(Company company: companies) {
            if(company.getId() == id) {
                return company;
            }
        }

        return null;
    }

    public Employee findEmployeeById(Company company, int id) {
        for(Employee employee: company.getEmployees()) {
            if(employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }
}
