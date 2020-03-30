package core.domain;

import core.domain.helper.BasicDomain;
import user.domain.User;

import java.util.Date;

/**
 * Employee domain
 */
public class Employee extends BasicDomain {

    public final static int DAYS_VACATION_BASIC = 21, DAYS_VACATION_MANAGEMENT = 45;

    /**
     * User who assigned on this employee (One-to-one rel)
     */
    private User user;

    /**
     * Company where employee works
     */
    private Company company;

    /**
     * Job title
     */
    private JobTitle jobTitle;

    /**
     * Total hours who need to be worked by the employee
     */
    private int weeklyWorkingHours;

    /**
     * Current wage of employee
     */
    private Wage currentWage;

    /**
     * Numbers of paid vacation
     */
    private int daysOfPaidVacation;

    /**
     * First day on this position
     */
    private Date startDateOfActivity;

    @Override
    public String toString() {
        return "Employee{" +
                "user=" + user +
                ", company=" + company +
                ", jobTitle=" + jobTitle +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getWeeklyWorkingHours() {
        return weeklyWorkingHours;
    }

    public void setWeeklyWorkingHours(int weeklyWorkingHours) {
        this.weeklyWorkingHours = weeklyWorkingHours;
    }

    public Wage getCurrentWage() {
        return currentWage;
    }

    public void setCurrentWage(Wage currentWage) {
        this.currentWage = currentWage;
    }

    public int getDaysOfPaidVacation() {
        return daysOfPaidVacation;
    }

    public void setDaysOfPaidVacation(int daysOfPaidVacation) {
        this.daysOfPaidVacation = daysOfPaidVacation;
    }

    public Date getStartDateOfActivity() {
        return startDateOfActivity;
    }

    public void setStartDateOfActivity(Date startDateOfActivity) {
        this.startDateOfActivity = startDateOfActivity;
    }
}
