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
}
