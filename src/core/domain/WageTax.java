package core.domain;

import core.domain.helper.BasicDomain;

/**
 * WageTax class
 */
public class WageTax extends BasicDomain {

    /**
     * Types of wage tax who can be assigned
     */
    public static final int TYPE_STATE_TAX = 1, TYPE_PENALTY_TAX = 2;

    /**
     * Types of wage tax amount
     */
    public static final int AMOUNT_TYPE_FIXED = 0, AMOUNT_TYPE_PERCENTAGE = 1;

    /**
     * Name of wage tax
     */
    private String name;

    /**
     * Type of tax
     */
    private int type;

    /**
     * Type of amount: fixed or percentage
     */
    private int typeOfAmount;

    /**
     * Amount of tax, if is fixed
     */
    private float amount;

    /**
     * Percentage of tax, if is percentage
     */
    private float percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTypeOfAmount() {
        return typeOfAmount;
    }

    public void setTypeOfAmount(int typeOfAmount) {
        this.typeOfAmount = typeOfAmount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
