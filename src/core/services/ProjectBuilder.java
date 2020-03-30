package core.services;

import core.domain.Company;
import core.domain.Customer;
import core.domain.Employee;
import core.domain.Project;
import util.helper.RandomGenerator;

import java.util.Date;

public class ProjectBuilder {

    private Project project;

    public ProjectBuilder() {
        project = new Project();
    }

    public ProjectBuilder fromCustomer(Customer customer) {
        project.setCustomer(customer);

        return this;
    }

    public ProjectBuilder toCompany(Company company) {
        project.setCompany(company);

        int employeeCount = 0;
        for (Employee employee : company.getEmployees()) {
            if (employeeCount > 2) {
                break;
            }

            if (employee.getJobTitle().isLeadershipPosition()) {
                project.setProjectManager(employee);
            } else {
                project.addTeamMember(employee);
                employeeCount++;
            }
        }

        return this;
    }

    public ProjectBuilder withName(String name) {
        project.setName(name);

        return this;
    }

    public ProjectBuilder withFixedBudget(float budget) {
        project.setType(Project.TYPE_FIXED);
        project.setBudget(budget);

        return this;
    }

    public ProjectBuilder withHourlyRate(float hourlyRate) {
        project.setType(Project.TYPE_HOURLY);
        project.setHourlyRate(hourlyRate);

        return this;
    }

    public Project build() {
        project.setId(RandomGenerator.generateId());
        project.setCreated(new Date());

        return project;
    }
}
