package core.domain;

import core.domain.helper.BasicDomain;

import java.util.ArrayList;

/**
 * Customer class
 */
public class Customer extends BasicDomain {

    /**
     * Name of Customer
     */
    private String name;

    /**
     * Projects of this customer
     */
    private ArrayList<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
