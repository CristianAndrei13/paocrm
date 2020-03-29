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


}
