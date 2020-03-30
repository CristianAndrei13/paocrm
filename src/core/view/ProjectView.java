package core.view;

import core.domain.Employee;
import core.domain.Project;

public class ProjectView {

    public static String projectReport(Project project) {

        StringBuilder projectReportText = new StringBuilder("---------\n" + "Name of project: " + project.getName() + "\n" +
                "Project manager: " + project.getProjectManager() + "\n");

        if (project.getType() == Project.TYPE_FIXED) {
            projectReportText.append("Project Type: ")
                    .append("FIXED BUDGET")
                    .append("\n")
                    .append("Project Budget: ")
                    .append(project.getBudget())
                    .append("\n");
        } else if (project.getType() == Project.TYPE_HOURLY) {
            projectReportText.append("Project Type: ")
                    .append("HOURLY RATE")
                    .append("\n")
                    .append("Project Rate: ")
                    .append(project.getHourlyRate())
                    .append("\n");
        }

        projectReportText.append("Employees list: \n" + "---------\n");

        for (Employee employee : project.getTeamMembers()) {
            projectReportText.append(EmployeeView.employeeDetails(employee)).append("--------\n");
        }

        projectReportText.append("\n");

        return projectReportText.toString();
    }
}
