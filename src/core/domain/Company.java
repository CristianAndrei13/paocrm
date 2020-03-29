package core.domain;

import core.domain.helper.BasicDomain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Company model
 */
public class Company extends BasicDomain {

    /**
     * Name of company
     */
    private String name;

    /**
     * Legal full name of company
     */
    private String legalCompanyName;

    /**
     * Unique identification code of company (ex: CUI in Romania)
     */
    private String uniqueIdentificationCode;

    /**
     * Date of official establishment
     */
    private Date dateOfEstablishment;

    /**
     * List of employees from company
     */
    private ArrayList<Employee> employees;

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

    public String getLegalCompanyName() {
        return legalCompanyName;
    }

    public void setLegalCompanyName(String legalCompanyName) {
        this.legalCompanyName = legalCompanyName;
    }

    public String getUniqueIdentificationCode() {
        return uniqueIdentificationCode;
    }

    public void setUniqueIdentificationCode(String uniqueIdentificationCode) {
        this.uniqueIdentificationCode = uniqueIdentificationCode;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }
}
