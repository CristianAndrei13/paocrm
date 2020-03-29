package core.domain;

import core.domain.helper.BasicDomain;

import java.util.ArrayList;

/**
 * Wage class
 */
public class Wage extends BasicDomain {

    /**
     * Employee who have this wage assigned
     */
    private Employee employee;

    /**
     * Gross amount per hour
     */
    private float grossAmountPerHour;

    /**
     * Taxes of employee gross salary
     */
    private ArrayList<WageTax> taxes;

    /**
     * If this is the current employee wage, then is true
     */
    private boolean isCurrent;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public float getGrossAmountPerHour() {
        return grossAmountPerHour;
    }

    public void setGrossAmountPerHour(float grossAmountPerHour) {
        this.grossAmountPerHour = grossAmountPerHour;
    }

    public ArrayList<WageTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<WageTax> taxes) {
        this.taxes = taxes;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
