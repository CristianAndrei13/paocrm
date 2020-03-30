package core.services;

import core.domain.Company;
import core.domain.Employee;
import core.domain.JobTitle;
import user.domain.User;
import user.services.UserBuilder;
import util.helper.RandomGenerator;

import java.util.Date;

/**
 * Employee builder pattern
 */
public class EmployeeBuilder {

    /**
     * Create new employee
     */
    public static Employee createEmployee(User user, Company company, JobTitle position, Date startDateOfActivity) {
        Employee employee = new Employee();

        employee.setCompany(company);
        employee.setJobTitle(position);
        employee.setUser(user);
        employee.setDaysOfPaidVacation(EmployeeBuilder.getVacationsDays(position));
        employee.setId(RandomGenerator.generateId());
        employee.setStartDateOfActivity(startDateOfActivity);

        return employee;
    }



    private static int getVacationsDays(JobTitle position) {
        if (position.isLeadershipPosition()) {
            return Employee.DAYS_VACATION_MANAGEMENT;
        } else {
            return Employee.DAYS_VACATION_BASIC;
        }
    }
}
