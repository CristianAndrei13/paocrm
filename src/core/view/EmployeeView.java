package core.view;

import core.domain.Company;
import core.domain.Employee;
import core.services.EmployeeService;
import core.services.WageService;

public class EmployeeView {

    public static String employeeDetails(Employee employee) {

        WageService wageService = new WageService();

        return "Employee ID: " + employee.getId() + "\n" +
                "Employee name: " + employee.getUser().getFirstName() + " " + employee.getUser().getLastName() + "\n" +
                "Employee email: " + employee.getUser().getEmail() + "\n" +
                "Employee position: " + employee.getJobTitle() + "\n" +
                "Employee wage: " + employee.getCurrentWage() + "\n" +
                "Employee net wage/month: $" + wageService.calculateMonthlyNetWageForEmployee(employee) + "\n";
    }
}
