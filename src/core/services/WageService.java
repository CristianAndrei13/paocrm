package core.services;

import core.domain.Employee;
import core.domain.Wage;
import core.domain.WageTax;
import core.persistence.WageTaxRepository;
import util.helper.RandomGenerator;

import java.util.ArrayList;

/**
 * WageService class
 */
public class WageService {

    private WageTaxRepository wageTaxRepository;

    public WageService() {
        this.wageTaxRepository = new WageTaxRepository();
    }

    public void assignWageForNewEmployee(Employee employee) {
        Wage wage = this.getWageForNewEmployee(employee);

        employee.setCurrentWage(wage);
    }

    public Wage getWageForNewEmployee(Employee employee) {
        Wage wage = this.buildWage(employee);

        this.assignBasicTaxesToWage(wage);

        return wage;
    }

    public Wage newWageForEmployee(Employee employee, float newWage) {
        employee.getCurrentWage().setCurrent(false);

        Wage wage = this.buildWage(employee);
        wage.setGrossAmountPerHour(newWage);

        this.assignBasicTaxesToWage(wage);

        return wage;
    }

    public void assignBasicTaxesToWage(Wage wage) {
        ArrayList<WageTax> taxes = this.wageTaxRepository.findBasicTaxes();

        taxes.forEach(wage::addTax);
    }

    public float calculateNetWageForEmployee(Employee employee) {
        Wage wage = employee.getCurrentWage();
        float netWage = wage.getGrossAmountPerHour();

        for (WageTax tax : wage.getTaxes()) {
            if (tax.getTypeOfAmount() == WageTax.AMOUNT_TYPE_FIXED) {
                netWage -= tax.getAmount();
            } else if (tax.getTypeOfAmount() == WageTax.AMOUNT_TYPE_PERCENTAGE) {
                netWage -= (netWage * tax.getPercentage() / 100);
            }
        }

        return netWage;
    }

    public float calculateMonthlyNetWageForEmployee(Employee employee) {
        return this.calculateNetWageForEmployee(employee) * employee.getWeeklyWorkingHours() * 4;
    }

    private Wage buildWage(Employee employee) {
        Wage wage = new Wage();

        wage.setId(RandomGenerator.generateId());
        wage.setCurrent(true);
        wage.setEmployee(employee);
        wage.setGrossAmountPerHour(employee.getJobTitle().getBaseGrossSalary());
        wage.setCreated(employee.getStartDateOfActivity());

        return wage;
    }
}
