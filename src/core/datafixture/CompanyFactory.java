package core.datafixture;

import core.domain.Company;
import core.domain.Employee;
import core.services.EmployeeService;
import util.fixtures.Factory;
import util.fixtures.RandomFixtures;
import util.helper.RandomGenerator;

import java.util.ArrayList;
import java.util.Date;

public class CompanyFactory implements Factory<Company> {
    public Company createRandom() {
        Company company = new Company();

        this.fillWithRandomData(company);
        this.fillWithRandomEmployees(company);

        return company;
    }

    private void fillWithRandomData(Company company) {
        int randomNumber = (int) (Math.random() * 100);

        company.setId(RandomGenerator.generateId());
        company.setName("Software Test " + randomNumber);
        company.setLegalCompanyName("SC Software Pro Test " + randomNumber + " SRL");
        company.setUniqueIdentificationCode("423423" + randomNumber);
        company.setWebsiteDomain("softwaretest" + randomNumber + ".ro");
        company.setDateOfEstablishment(new Date());
        company.setCreated(new Date());
    }

    private void fillWithRandomEmployees(Company company) {
        RandomFixtures<Employee> fixtures = new RandomFixtures<>();

        ArrayList<Employee> employees = fixtures.generateTwelve(new EmployeeFactory());
        for (Employee employee : employees) {
            employee.setCompany(company);
            employee.getUser().setEmail(EmployeeService.createCompanyEmail(employee));
            company.addEmployee(employee);
        }
    }
}
