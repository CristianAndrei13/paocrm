package core.domain;

import core.domain.helper.BasicDomain;

import java.util.ArrayList;

/**
 * Department class
 */
public class Department extends BasicDomain {

    /**
     * Name of department
     */
    private String name;

    /**
     * Employees of this department
     */
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
