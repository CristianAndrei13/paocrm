package core.domain;

import core.domain.helper.BasicDomain;

import java.util.ArrayList;

public class Project extends BasicDomain {

    public final static int TYPE_HOURLY = 0, TYPE_FIXED = 1;

    /**
     * Name of project
     */
    private String name;

    /**
     * Type of project
     */
    private int type;

    /**
     * Customer of this project
     */
    private Customer customer;

    /**
     * Company who work on this project
     */
    private Company company;

    /**
     * Employees who work on this project
     */
    private ArrayList<Employee> teamMembers;

    /**
     * Project manager
     */
    private Employee projectManager;

    /**
     * Budget who customer assigned to this project, if its fixed price
     */
    private float budget;

    /**
     * Hourly rate, if its hourly priced
     */
    private float hourlyRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(Employee employee) {
        this.teamMembers.add(employee);
    }

    public void removeTeamMember(Employee employee) {
        this.teamMembers.remove(employee);
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
