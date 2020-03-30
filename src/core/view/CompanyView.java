package core.view;

import core.domain.Company;
import core.domain.Employee;

public class CompanyView {

    public static String companyReport(Company company) {

        StringBuilder companyReportText = new StringBuilder("---------\n" +
                "ID company: " + company.getId() + "\n" +
                "Name of company: " + company + "\n" +
                "Date of establishment: " + company.getDateOfEstablishment() + "\n" +
                "Website domain: " + company.getWebsiteDomain() + "\n" +
                "Employees list: \n" + "---------\n");

        for (Employee employee : company.getEmployees()) {
            companyReportText.append(EmployeeView.employeeDetails(employee)).append("--------\n");
        }

        companyReportText.append("\n");

        return companyReportText.toString();
    }
}
