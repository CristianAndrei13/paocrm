package core.view;

import core.datafixture.CompanyFactory;
import core.domain.Company;
import core.domain.Employee;
import core.domain.JobTitle;
import core.persistence.CompanyRepository;
import core.services.EmployeeService;
import user.domain.User;
import user.services.UserBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConsoleView {

    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        CompanyRepository companyRepository = new CompanyRepository();

        ArrayList<Company> companies = companyRepository.findAll();

        companies.forEach(company -> System.out.println(CompanyView.companyReport(company)));
    }
}
