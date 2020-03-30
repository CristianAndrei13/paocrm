package core.view;

import core.domain.Company;
import core.domain.Employee;

public class CompanyView {

    public static String companyReport(Company company) {

        StringBuilder companyReportText = new StringBuilder("Name of company: " + company + "\n" +
                "Date of establishment: " + company.getDateOfEstablishment() + "\n" +
                "Website domain: " + company.getWebsiteDomain() + "\n" +
                "Employees list: \n");

        for (Employee employee : company.getEmployees()) {
            companyReportText.append("Employee ID: ").append(employee.getId()).append("\n");
            companyReportText.append("Employee name: ").append(employee.getUser().getFirstName()).append(" ").append(employee.getUser().getLastName()).append("\n");
            companyReportText.append("Employee email: ").append(employee.getUser().getEmail()).append("\n");
            companyReportText.append("Employee position: ").append(employee.getJobTitle()).append("\n");
            companyReportText.append("Employee wage: ").append(employee.getCurrentWage()).append("\n");
        }

        return companyReportText.toString();
    }
}
