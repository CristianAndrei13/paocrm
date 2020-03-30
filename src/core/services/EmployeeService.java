package core.services;

import core.domain.Company;
import core.domain.Employee;
import core.domain.JobTitle;
import core.domain.Wage;
import user.domain.User;
import user.services.UserBuilder;

import java.util.Date;

/**
 * Employee service
 */
public class EmployeeService {

    private WageService wageService;

    public EmployeeService() {
        this.wageService = new WageService();
    }

    /**
     * Register new employee
     */
    public Employee registerNewEmployee(String firstName, String lastName, Company company, JobTitle position, Date startDateOfActivity) {
        User userForEmployee = UserBuilder.createBasicUser(firstName, lastName, null);

        Employee employee = EmployeeBuilder.createEmployee(userForEmployee, company, position, startDateOfActivity);
        employee.getUser().setEmail(createCompanyEmail(employee));

        wageService.assignWageForNewEmployee(employee);
        //TODO: Persisting in database, logs

        return employee;
    }

    /**
     * Get company email
     */
    public static String createCompanyEmail(Employee employee) {
        return employee.getUser().getUsername() + "@" + employee.getCompany().getWebsiteDomain();
    }
}
