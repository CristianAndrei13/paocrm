package core.view;

import core.domain.*;
import core.persistence.CompanyRepository;
import core.persistence.JobTitleRepository;
import core.persistence.ProjectRepository;
import core.services.EmployeeService;
import core.services.ProjectBuilder;
import core.services.WageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConsoleView {

    private static Scanner scanner = new Scanner(System.in);
    private static CompanyRepository companyRepository = new CompanyRepository();
    private static ProjectRepository projectRepository = new ProjectRepository();
    private static JobTitleRepository jobTitleRepository = new JobTitleRepository();

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to PAO CRM. Select your option:");

        while (true) {

            System.out.println("1. List companies details");
            System.out.println("2. List projects");
            System.out.println("3. Add project");
            System.out.println("4. See employee details");
            System.out.println("5. Company report");
            System.out.println("6. List job titles");
            System.out.println("7. Add new employee");
            System.out.println("8. Raise wage employee");
            System.out.println("9. Promote employee to new job title");
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
                    case 6:
                        seeJobTitles();
                    case 7:
                        addNewEmployee();
                    case 8:
                        raiseWageEmployee();
                    case 9:
                        promoteEmployee();
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

    public static void seeJobTitles() throws Exception {
        ArrayList<JobTitle> jobTitles = jobTitleRepository.findAll();

        jobTitles.forEach(jobTitle -> System.out.println("#" + jobTitle.getId() + " " + jobTitle));
    }

    public static void addNewEmployee() throws Exception {
        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        System.out.println("Job title from CRM ID: ");
        int jobTitleId = scanner.nextInt();

        JobTitle jobTitle = jobTitleRepository.findById(jobTitleId);
        if (jobTitle == null) {
            throw new Exception("JobTitle ID is invalid.");
        }

        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();

        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.registerNewEmployee(firstName, lastName, company, jobTitle, new Date());

        EmployeeView.employeeDetails(employee);

        System.out.println("Employee registered successfully.");
    }

    public static void raiseWageEmployee() throws Exception {
        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        CompanyView.companyReport(company);

        System.out.println("Employee from CRM ID: ");
        int employeeId = scanner.nextInt();

        Employee employee = companyRepository.findEmployeeById(company, employeeId);
        if (employee == null) {
            throw new Exception("Employee ID is invalid.");
        }

        System.out.println("New hour wage: ");
        float wage = scanner.nextInt();

        WageService wageService = new WageService();
        wageService.newWageForEmployee(employee, wage);

        System.out.println("Wage raised succesfully");
    }

    public static void promoteEmployee() throws Exception {
        System.out.println("Company from CRM ID: ");
        int companyId = scanner.nextInt();

        Company company = companyRepository.findById(companyId);
        if (company == null) {
            throw new Exception("Company ID is invalid.");
        }

        CompanyView.companyReport(company);

        System.out.println("Employee from CRM ID: ");
        int employeeId = scanner.nextInt();

        Employee employee = companyRepository.findEmployeeById(company, employeeId);
        if (employee == null) {
            throw new Exception("Employee ID is invalid.");
        }

        seeJobTitles();

        System.out.println("New job title ID: ");
        int jobTitleId = scanner.nextInt();

        JobTitle jobTitle = jobTitleRepository.findById(jobTitleId);
        if (jobTitle == null) {
            throw new Exception("JobTitle ID is invalid.");
        }

        EmployeeService employeeService = new EmployeeService();
        employeeService.promoteEmployee(employee, jobTitle);

        System.out.println("Employee promoted.");
    }
}
