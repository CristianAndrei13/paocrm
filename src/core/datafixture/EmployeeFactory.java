package core.datafixture;

import core.domain.Employee;
import core.services.WageService;
import user.datafixture.UserFactory;
import util.fixtures.Factory;
import util.helper.RandomGenerator;

import java.util.Date;

public class EmployeeFactory implements Factory<Employee> {

    private UserFactory userFactory = new UserFactory();
    private JobTitleFactory jobTitleFactory = new JobTitleFactory();
    private WageService wageService = new WageService();

    public Employee createRandom() {
        Employee employee = new Employee();

        int randomNumber = (int) (Math.random() * 100);
        employee.setId(RandomGenerator.generateId());
        employee.setUser(userFactory.createRandom());
        employee.setId(randomNumber);
        employee.setWeeklyWorkingHours(40);
        employee.setStartDateOfActivity(new Date());
        employee.setJobTitle(jobTitleFactory.createRandom());
        if (employee.getJobTitle().isLeadershipPosition()) {
            employee.setDaysOfPaidVacation(Employee.DAYS_VACATION_MANAGEMENT);
        } else {
            employee.setDaysOfPaidVacation(Employee.DAYS_VACATION_BASIC);
        }
        wageService.assignWageForNewEmployee(employee);

        return employee;
    }
}
