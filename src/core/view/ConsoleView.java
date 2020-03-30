package core.view;

import core.domain.Company;
import core.domain.Customer;
import core.domain.Employee;
import core.domain.Project;
import core.persistence.CompanyRepository;
import core.persistence.ProjectRepository;
import core.services.ProjectBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    private static Scanner scanner = new Scanner(System.in);
    private static CompanyRepository companyRepository = new CompanyRepository();
    private static ProjectRepository projectRepository = new ProjectRepository();

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to PAO CRM. Select your option:");

        while (true) {

            System.out.println("1. List companies details");
            System.out.println("2. List projects");
            System.out.println("3. Add project");
            System.out.println("4. See employee details");
            System.out.println("5. Company report");
            System.out.println("0. Exit");

            int choice;
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        listCompanies();
                    case 2:
                        listProjects();
                    case 3:
                        addNewProject();
                    case 4:
                        seeEmployeeDetails();
                    case 5:
                        seeCompanyDetails();
                    case 0:
                        System.out.println("Have a great day!");
                        return;
                    default:
                        System.out.println("Invalid select");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void listCompanies() {
        ArrayList<Company> companies = companyRepository.findAll();

        companies.forEach(company -> System.out.println(CompanyView.companyReport(company)));
    }

    public static void listProjects() {
        ArrayList<Project> projects = projectRepository.findAll();

        projects.forEach(project -> System.out.println(ProjectView.projectReport(project)));
    }

    public static void addNewProject() throws Exception {

        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        System.out.println("Client name: ");

        String clientName = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(clientName);

        System.out.println("Project name: ");

        String projectName = scanner.nextLine();
        ProjectBuilder projectBuilder = new ProjectBuilder();
        projectBuilder.fromCustomer(customer)
                .withName(projectName)
                .toCompany(company);

        System.out.println("Type of project (0. hourly rate, 1. fixed price): ");
        int projectType = scanner.nextInt();

        if (projectType == Project.TYPE_FIXED) {
            System.out.println("What is your budget?");
            float budget = scanner.nextFloat();
            projectBuilder.withFixedBudget(budget);
        } else if (projectType == Project.TYPE_HOURLY) {
            System.out.println("What is your wished hourly rate?");
            float budget = scanner.nextFloat();
            projectBuilder.withHourlyRate(budget);
        } else {
            throw new Exception("Invalid project type");
        }

        projectRepository.persist(projectBuilder.build());
        System.out.println("Project added succesfully");
    }

    public static void seeEmployeeDetails() throws Exception {
        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        System.out.println("Employee from CRM ID: ");
        int employeeId = scanner.nextInt();

        boolean ok = false;
        for (Employee employee : company.getEmployees()) {
            if (employee.getId() == employeeId) {
                EmployeeView.employeeDetails(employee);
                ok = true;
                break;
            }
        }
        if (!ok) {
            throw new Exception("Employee ID is invalid.");
        }
    }

    public static void seeCompanyDetails() throws Exception {
        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        CompanyView.companyReport(company);
    }
}
